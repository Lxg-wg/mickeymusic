package indi.wwq.mickey.pojo;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "gp_album")
public class GpAlbum implements Serializable {
    /**
     * 专辑id
     */
    @Id
    @Column(name = "album_id")
    private String albumId;

    /**
     * 专辑名
     */
    @Column(name = "album_name")
    private String albumName;

    /**
     * 专辑的歌曲数
     */
    @Column(name = "album_count")
    private Integer albumCount;

    private static final long serialVersionUID = 1L;

    /**
     * 获取专辑id
     *
     * @return album_id - 专辑id
     */
    public String getAlbumId() {
        return albumId;
    }

    /**
     * 设置专辑id
     *
     * @param albumId 专辑id
     */
    public void setAlbumId(String albumId) {
        this.albumId = albumId == null ? null : albumId.trim();
    }

    /**
     * 获取专辑名
     *
     * @return album_name - 专辑名
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     * 设置专辑名
     *
     * @param albumName 专辑名
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    /**
     * 获取专辑的歌曲数
     *
     * @return album_count - 专辑的歌曲数
     */
    public Integer getAlbumCount() {
        return albumCount;
    }

    /**
     * 设置专辑的歌曲数
     *
     * @param albumCount 专辑的歌曲数
     */
    public void setAlbumCount(Integer albumCount) {
        this.albumCount = albumCount;
    }
}