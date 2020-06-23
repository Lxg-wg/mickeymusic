package indi.wwq.mickey.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "gp_song_info")
public class GpSongInfo implements Serializable {
    /**
     * 歌曲id
     */
    @Id
    @Column(name = "song_id")
    private String songId;

    /**
     * 歌名
     */
    @Column(name = "song_name")
    private String songName;

    /**
     * 歌手名
     */
    @Column(name = "singer_name")
    private String singerName;

    /**
     * 专辑的id
     */
    @Column(name = "albumId")
    private String albumid;

    /**
     * 歌曲时长
     */
    @Column(name = "song_interval")
    private Integer songInterval;

    /**
     * 歌曲的mid
     */
    @Column(name = "song_mid")
    private String songMid;

    private static final long serialVersionUID = 1L;

    /**
     * 获取歌曲id
     *
     * @return song_id - 歌曲id
     */
    public String getSongId() {
        return songId;
    }

    /**
     * 设置歌曲id
     *
     * @param songId 歌曲id
     */
    public void setSongId(String songId) {
        this.songId = songId == null ? null : songId.trim();
    }

    /**
     * 获取歌名
     *
     * @return song_name - 歌名
     */
    public String getSongName() {
        return songName;
    }

    /**
     * 设置歌名
     *
     * @param songName 歌名
     */
    public void setSongName(String songName) {
        this.songName = songName == null ? null : songName.trim();
    }

    /**
     * 获取歌手名
     *
     * @return singer_name - 歌手名
     */
    public String getSingerName() {
        return singerName;
    }

    /**
     * 设置歌手名
     *
     * @param singerName 歌手名
     */
    public void setSingerName(String singerName) {
        this.singerName = singerName == null ? null : singerName.trim();
    }

    /**
     * 获取专辑的id
     *
     * @return albumId - 专辑的id
     */
    public String getAlbumid() {
        return albumid;
    }

    /**
     * 设置专辑的id
     *
     * @param albumid 专辑的id
     */
    public void setAlbumid(String albumid) {
        this.albumid = albumid == null ? null : albumid.trim();
    }

    /**
     * 获取歌曲时长
     *
     * @return song_interval - 歌曲时长
     */
    public Integer getSongInterval() {
        return songInterval;
    }

    /**
     * 设置歌曲时长
     *
     * @param songInterval 歌曲时长
     */
    public void setSongInterval(Integer songInterval) {
        this.songInterval = songInterval;
    }

    /**
     * 获取歌曲的mid
     *
     * @return song_mid - 歌曲的mid
     */
    public String getSongMid() {
        return songMid;
    }

    /**
     * 设置歌曲的mid
     *
     * @param songMid 歌曲的mid
     */
    public void setSongMid(String songMid) {
        this.songMid = songMid == null ? null : songMid.trim();
    }
}