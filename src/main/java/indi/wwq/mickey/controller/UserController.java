package indi.wwq.mickey.controller;

import indi.wwq.mickey.pojo.*;
import indi.wwq.mickey.service.GpAlbumService;
import indi.wwq.mickey.service.GpPlayService;
import indi.wwq.mickey.service.GpSongInfoService;
import indi.wwq.mickey.service.GpUserService;
import indi.wwq.mickey.utils.ProcessingFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static indi.wwq.mickey.utils.ProcessingFormat.interceptionTooLong;

/**
 * 用户的登录与管理
 * @author wg
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final GpUserService userService;
    private final GpPlayService playService;
    private final GpSongInfoService songInfoService;
    private final GpAlbumService albumService;
    static GpUser gpUser;
    static List<GpPlay> gpPlays;
    String regId = "\\d{6,20}";
    String regPassword = "(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}";
    String regNickname ="[\u4e00-\u9fa5_a-zA-Z0-9]{2,10}";
    public UserController(GpUserService userService, GpPlayService playService, GpSongInfoService songInfoService, GpAlbumService albumService) {
        this.userService = userService;
        this.playService = playService;
        this.songInfoService = songInfoService;
        this.albumService = albumService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    private boolean login(HttpServletResponse response, @RequestBody Map<String, Object> data) {
        String userId = data.get("userId").toString().trim();
        String password = data.get("password").toString().trim();
        if(userId.matches(regId)&&password.matches(regPassword)){
            return false;
        }
        gpUser = userService.selectByPrimaryKey(userId);
        if (gpUser != null && gpUser.getPassword().equals(password)) {
            gpUser.setLastlogin(new Date());
            userService.updateByPrimaryKeySelective(gpUser);
            IndexController.gpUser = UserController.gpUser;
            if (Boolean.parseBoolean(data.get("autoLogin").toString())) {
                Cookie mickeyUserId = new Cookie("mickeyUserId", "" + gpUser.getUserId());
                Cookie mickeyPassword = new Cookie("mickeyPassword", gpUser.getPassword());
                mickeyUserId.setMaxAge(60 * 60 * 24 * 30);
                mickeyPassword.setMaxAge(60 * 60 * 24 * 30);
                mickeyUserId.setPath("/");
                mickeyPassword.setPath("/");
                response.addCookie(mickeyUserId);
                response.addCookie(mickeyPassword);
            }
            IndexController.gpUser = UserController.gpUser;
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/reg")
    @ResponseBody
    private String reg(@RequestBody Map<String, Object> data,ModelMap map) {
        String nickname=data.get("nickname").toString().trim();
        String password=data.get("password").toString().trim();
        if(nickname.matches(regNickname)&&password.matches(regPassword)){
            return "false";
        }
        GpUser user = new GpUser();
        Date now = new Date();
        user.setNickname(nickname);
        user.setPassword(password);
        user.setRegtime(now);
        user.setLastlogin(now);
        user.setStatus(0);
        boolean reg = false;
        String id = "";
        for (int i = 0; i <=10000; i++) {
            if (reg) {
                break;
            }
            try {
                 id = getRandomId(user);
                user.setUserId(id);
                userService.insertSelective(user);
                reg = true;
            } catch (Exception e) {
                System.out.println("----------Warning:   repetition");
                return "false";
            }
        }
        return id;
    }

    @RequestMapping(value = "/musichistory", method = RequestMethod.GET)
    @ResponseBody
    private Object getHistoryMusic(ModelMap map) {
        if (IndexController.gpUser != null && gpUser == null) {
            gpUser = IndexController.gpUser;
        }
        if (gpUser != null) {
            String userId = gpUser.getUserId();
            GpPlay gpPlay = new GpPlay();
            gpPlay.setUserId(userId);
            gpPlays = playService.queryListPaged(gpPlay, 0, 50);
            List<SongInfo> songInfos = new ArrayList<>();
            for (GpPlay play : gpPlays) {
                GpSongInfo gpSongInfo = songInfoService.selectByPrimaryKey(play.getSongId());
                GpAlbum album = albumService.selectByPrimaryKey(play.getAlbumId());
                if (gpSongInfo == null || album == null) {
                    return "no data";
                }
                SongInfo songInfo = new SongInfo();
                fillField(songInfo, gpSongInfo, album);
                songInfos.add(songInfo);
            }
            return songInfos;
        }
        return "no login";
    }

    @RequestMapping(value = "/isLogin", method = RequestMethod.GET)
    @ResponseBody
    private boolean isLogin() {
        boolean isLogin = true;
        if (IndexController.gpUser == null) {
            isLogin = false;
        }
        return isLogin;
    }

    private void fillField(SongInfo songInfo, GpSongInfo gpSongInfo, GpAlbum album) {
        //gpSongInfo
        songInfo.setSongMid(gpSongInfo.getSongMid());
        songInfo.setSongId(gpSongInfo.getSongId());
        songInfo.setInterval(gpSongInfo.getSongInterval());
        songInfo.setIntervalMmss(ProcessingFormat.toMmss(gpSongInfo.getSongInterval()));
        songInfo.setSongName(interceptionTooLong(gpSongInfo.getSongName(), 11));
        songInfo.setCompleteSongName(gpSongInfo.getSongName());
        songInfo.setSingerName(interceptionTooLong(gpSongInfo.getSingerName(), 6));
        songInfo.setCompleteSingerName(gpSongInfo.getSingerName());
        //gpAlbum
        songInfo.setAlbumName(interceptionTooLong(album.getAlbumName(), 10));
        songInfo.setAlbumId(album.getAlbumId());
        songInfo.setCompleteAlbumName(album.getAlbumName());
    }

    private String getRandomId(GpUser user) {
        String id = "" + UUID.randomUUID().hashCode() + (user.getPassword() + user.getNickname()).hashCode() + new Random(System.currentTimeMillis()).nextInt(1000000000);
        return "" + Math.abs(id.hashCode());
    }

}
