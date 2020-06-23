package indi.wwq.mickey.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "gp_play")
public class GpPlay implements Serializable {
    /**
     * 由user_id和song_id拼接而成
     */
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "song_id")
    private String songId;

    @Column(name = "album_id")
    private String albumId;

    /**
     * 0代表qq音乐
     */
    private Integer type;

    /**
     * 上次播放时间
     */
    @Column(name = "last_time")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",locale = "zh",timezone="GMT+8")
    private Date lastTime;

    /**
     * 是否显示(0,-1)
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取由user_id和song_id拼接而成
     *
     * @return id - 由user_id和song_id拼接而成
     */
    public String getId() {
        return id;
    }

    /**
     * 设置由user_id和song_id拼接而成
     *
     * @param id 由user_id和song_id拼接而成
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return song_id
     */
    public String getSongId() {
        return songId;
    }

    /**
     * @param songId
     */
    public void setSongId(String songId) {
        this.songId = songId == null ? null : songId.trim();
    }

    /**
     * @return album_id
     */
    public String getAlbumId() {
        return albumId;
    }

    /**
     * @param albumId
     */
    public void setAlbumId(String albumId) {
        this.albumId = albumId == null ? null : albumId.trim();
    }

    /**
     * 获取0代表qq音乐
     *
     * @return type - 0代表qq音乐
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0代表qq音乐
     *
     * @param type 0代表qq音乐
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取上次播放时间
     *
     * @return last_time - 上次播放时间
     */
    public Date getLastTime() {
        return lastTime;
    }

    /**
     * 设置上次播放时间
     *
     * @param lastTime 上次播放时间
     */
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    /**
     * 获取是否显示(0,-1)
     *
     * @return status - 是否显示(0,-1)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否显示(0,-1)
     *
     * @param status 是否显示(0,-1)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GpPlay{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", songId='" + songId + '\'' +
                ", albumId='" + albumId + '\'' +
                ", type=" + type +
                ", lastTime=" + lastTime +
                ", status=" + status +
                '}';
    }
}