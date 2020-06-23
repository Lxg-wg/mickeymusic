package indi.wwq.mickey.controller;

import com.google.gson.Gson;
import indi.wwq.mickey.pojo.*;
import indi.wwq.mickey.pojo.qqmusic.QQMusicApiResource;
import indi.wwq.mickey.pojo.qqmusic.QQSongPlayJson;
import indi.wwq.mickey.service.GpAlbumService;
import indi.wwq.mickey.service.GpPlayService;
import indi.wwq.mickey.service.GpSongInfoService;
import indi.wwq.mickey.utils.JsonManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

/**
 * 根据songMid返回播放链接,并在用户已登录的情况下保存播放信息
 * @author wg
 */
@Controller
@RequestMapping("/mickey")
public class PlayController {
    final GpPlayService playService;
    final GpAlbumService albumService;
    final GpSongInfoService songInfoService;
    final QQMusicApiResource qqResource;

    public PlayController(QQMusicApiResource qqResource, GpPlayService playService, GpAlbumService albumService, GpSongInfoService songInfoService) {
        this.qqResource = qqResource;
        this.playService = playService;
        this.albumService = albumService;
        this.songInfoService = songInfoService;
    }

    @RequestMapping(value = "/play", method = RequestMethod.POST)
    @ResponseBody
    private String getPlayLink(ModelMap map, @RequestBody Map<String, Object> request) {
        Gson gson = new Gson();
        SongInfo songInfo = gson.fromJson(gson.toJson(request.get("songInfo")), SongInfo.class);
        String mid = songInfo.getSongMid();
        String playLink = qqResource.getPlayLinkHead() + mid + qqResource.getPlayLinkTail();
        String json = JsonManager.getJsonByUrl(playLink);
        QQSongPlayJson playJson = gson.fromJson(json, QQSongPlayJson.class);
        if (playJson.getCode() == 0) {
            String sip = playJson.getReq_0().getData().getSip().get(0);
            String purl = playJson.getReq_0().getData().getMidurlinfo().get(0).getPurl();
            GpUser gpUser = IndexController.gpUser;
            if (gpUser != null) {
                String id = gpUser.getUserId() + songInfo.getSongId();
                if (playService.selectByPrimaryKey(id) == null) {
                    GpPlay gpPlay = new GpPlay();
                    GpSongInfo gpSongInfo = new GpSongInfo();
                    GpAlbum gpAlbum = new GpAlbum();
                    fillAll(gpPlay, gpSongInfo, gpAlbum, songInfo);
                    playService.insertSelective(gpPlay);
                    if (songInfoService.selectByPrimaryKey(gpSongInfo)==null){
                        songInfoService.insertSelective(gpSongInfo);
                    }
                    if (albumService.selectByPrimaryKey(gpAlbum)==null){
                        albumService.insertSelective(gpAlbum);
                    }
                } else {
                    GpPlay play = new GpPlay();
                    play.setId(id);
                    play.setLastTime(new Date());
                    playService.updateByPrimaryKeySelective(play);
                }
            }

            return sip + purl;
        }

        return "-1";
    }

    /**
     *
     *将数据填充进字段
     */
    private void fillAll(GpPlay play, GpSongInfo gpSongInfo, GpAlbum gpAlbum, SongInfo songInfo) {
        //play
        play.setId( IndexController.gpUser.getUserId() + songInfo.getSongId());
        play.setUserId(IndexController.gpUser.getUserId());
        play.setSongId(songInfo.getSongId());
        play.setAlbumId(songInfo.getAlbumId());
        play.setType(0);
        play.setLastTime(new Date());
        play.setStatus(0);
        //gpSongInfo
        gpSongInfo.setSongId(songInfo.getSongId());
        gpSongInfo.setSongName(songInfo.getCompleteSongName());
        gpSongInfo.setSingerName(songInfo.getCompleteSingerName());
        gpSongInfo.setAlbumid(songInfo.getAlbumId());
        gpSongInfo.setSongInterval(songInfo.getInterval());
        gpSongInfo.setSongMid(songInfo.getSongMid());
        //gpAlbum
        gpAlbum.setAlbumId(songInfo.getAlbumId());
        gpAlbum.setAlbumName(songInfo.getAlbumName());
        gpAlbum.setAlbumCount(0);
    }

}
