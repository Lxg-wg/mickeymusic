package indi.wwq.mickey.controller;

import com.google.gson.Gson;
import indi.wwq.mickey.pojo.GpUser;
import indi.wwq.mickey.pojo.qqmusic.QQMusicApiResource;
import indi.wwq.mickey.pojo.qqmusic.QQTopSongJson.SonglistBean;
import indi.wwq.mickey.pojo.qqmusic.QQTopSongJson.SonglistBean.*;
import indi.wwq.mickey.pojo.SongInfo;
import indi.wwq.mickey.pojo.qqmusic.QQTopSongJson;
import indi.wwq.mickey.service.GpUserService;
import indi.wwq.mickey.utils.JsonManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import indi.wwq.mickey.pojo.qqmusic.QQSongJson.DataBean.SongBean.*;
import indi.wwq.mickey.pojo.qqmusic.QQSongJson.DataBean.SongBean.ListBean.*;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.zip.DataFormatException;

import static indi.wwq.mickey.utils.ProcessingFormat.interceptionTooLong;
import static indi.wwq.mickey.utils.ProcessingFormat.toMmss;

/**
 * 主页的controller类
 * @author wg
 *
 */
@Controller
@RequestMapping("/mickey")
public class IndexController {
    /**
     * gpUser用户保存用户的信息
     * @see IndexController#gpUser
     */
    public static GpUser gpUser;
    final GpUserService userService;
    private final QQMusicApiResource qqResource;
    Random r = new Random();
    public IndexController(GpUserService userService, QQMusicApiResource qqResource) {
        this.userService = userService;
        this.qqResource = qqResource;
    }

    @RequestMapping("/index")
    private String getIndex(HttpServletRequest request, ModelMap map){
        String topJson = JsonManager.getJsonByUrl(qqResource.getTop());
        Gson gson = new Gson();
        QQTopSongJson topSong = gson.fromJson(topJson, QQTopSongJson.class);
        if (topSong.getCode()==0){
        List<SonglistBean> listBean = topSong.getSonglist();
        List<SongInfo> topSongInfos = new ArrayList<>();
        int rSearchKey = r.nextInt(100);
        int count = 0;
        //填充top100歌曲数据,并随机生成推荐搜索
        for (SonglistBean bean : listBean) {
            SongInfo songInfo = new SongInfo();
            fillField(songInfo, bean.getData());
            StringBuilder singerName = new StringBuilder();
            count ++;
            List<DataBean.SingerBean> singers = bean.getData().getSinger();
            if (rSearchKey == count) {
                String searchKey;
                if(r.nextInt(100)<50){
                    searchKey = singers.get(r.nextInt(singers.size())).getName();
                }else{
                    searchKey = bean.getData().getSongname();
                }
                map.addAttribute("searchKey",searchKey );

            }
            for (DataBean.SingerBean singer : singers) {
                singerName.append(singer.getName()).append("/");
            }
            songInfo.setSingerName(interceptionTooLong(singerName.substring(0, singerName.length() - 1), 12));
            songInfo.setCompleteSingerName(singerName.substring(0, singerName.length() - 1));
            topSongInfos.add(songInfo);
        }
        map.addAttribute("top100",topSongInfos);
        }

        return "thymeleaf/index";
    }

    private void fillField(SongInfo songInfo, DataBean listBean) {
        songInfo.setSongId(String.valueOf(listBean.getSongid()));
        songInfo.setSongMid(listBean.getSongmid());
        songInfo.setSongName(interceptionTooLong(listBean.getSongname(),17));
        songInfo.setCompleteSongName(listBean.getSongname());
        songInfo.setAlbumId(String.valueOf(listBean.getAlbumid()));
        songInfo.setAlbumName(interceptionTooLong(listBean.getAlbumname(),16));
        songInfo.setCompleteAlbumName(listBean.getAlbumname());
        songInfo.setIntervalMmss(toMmss(listBean.getInterval()));
        songInfo.setInterval(listBean.getInterval());
    }
}
