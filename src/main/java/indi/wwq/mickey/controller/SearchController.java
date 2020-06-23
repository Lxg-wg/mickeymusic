package indi.wwq.mickey.controller;

import com.google.gson.Gson;
import indi.wwq.mickey.pojo.qqmusic.QQMusicApiResource;
import indi.wwq.mickey.pojo.qqmusic.QQSongJson;
import indi.wwq.mickey.pojo.SongInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import indi.wwq.mickey.utils.JsonManager;
import indi.wwq.mickey.pojo.qqmusic.QQSongJson.DataBean.SongBean.*;
import indi.wwq.mickey.pojo.qqmusic.QQSongJson.DataBean.SongBean.ListBean.*;
import java.util.ArrayList;
import java.util.List;
import static indi.wwq.mickey.utils.ProcessingFormat.*;

/**
 * 接收搜索关键字,根据api返回json数据,然后通过Gson转化为实体对象
 * @author wg
 */
@Controller
@RequestMapping("/list")
public class SearchController {
    private final QQMusicApiResource qqResource;
    private int page = 1;
    private int n = 30;
    private String searchKey = "";

    public SearchController(QQMusicApiResource qqResource) {
        this.qqResource = qqResource;
    }

    @RequestMapping("/search")
    private String querySongList(String searchKey, ModelMap map) {
        this.searchKey = searchKey;
        String url = qqResource.getSearch() + "&p=" + page + "&n=" + n + "&w=" + searchKey;
        String json =  JsonManager.getJsonByUrl(url);
        Gson gson = new Gson();
        QQSongJson songJson = gson.fromJson(json, QQSongJson.class);
        if (songJson.getCode() == 0) {
            List<ListBean> list = songJson.getData().getSong().getList();
            List<SongInfo> songInfos = new ArrayList<>();
            for (ListBean listBean : list) {
                SongInfo songInfo = new SongInfo();
                fillField(songInfo,listBean);
                StringBuilder singerName = new StringBuilder();
                for (SingerBean bean : listBean.getSinger()) {
                    singerName.append(bean.getName()).append("/");
                }
                songInfo.setSingerName(interceptionTooLong(singerName.substring(0, singerName.length() - 1),12));
                songInfo.setCompleteSingerName(singerName.substring(0, singerName.length() - 1));
                songInfos.add(songInfo);
            }
            map.addAttribute("songList", songInfos);
            map.addAttribute("searchKey", searchKey);
        }
        return "thymeleaf/search";
    }

    /**
     * 填充songInfo的字段
     */
    private void fillField(SongInfo songInfo, ListBean listBean) {
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
