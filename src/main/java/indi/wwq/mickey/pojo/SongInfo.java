package indi.wwq.mickey.pojo;

/**
 * 该实体类用户存储音乐信息重要的字段
 * @author wg
 */
public class  SongInfo {
    private String songId;
    private String songName;
    private String completeSongName;
    private String singerName;
    private String completeSingerName;
    private String albumId;
    private String albumName;
    private String completeAlbumName;
    private int interval;
    private String intervalMmss;
    private String songMid;

    public String getCompleteSongName() {
        return completeSongName;
    }

    public void setCompleteSongName(String completeSongName) {
        this.completeSongName = completeSongName;
    }

    public String getCompleteSingerName() {
        return completeSingerName;
    }

    public void setCompleteSingerName(String completeSingerName) {
        this.completeSingerName = completeSingerName;
    }

    public String getCompleteAlbumName() {
        return completeAlbumName;
    }

    public void setCompleteAlbumName(String completeAlbumName) {
        this.completeAlbumName = completeAlbumName;
    }

    public String getSongMid() {
        return songMid;
    }

    public void setSongMid(String songMid) {
        this.songMid = songMid;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getIntervalMmss() {
        return intervalMmss;
    }

    public void setIntervalMmss(String intervalMmss) {
        this.intervalMmss = intervalMmss;
    }

    @Override
    public String toString() {
        return "{" +
                "songId:'" + songId + '\'' +
                ", songName:'" + songName + '\'' +
                ", completeSongName:'" + completeSongName + '\'' +
                ", singerName:'" + singerName + '\'' +
                ", completeSingerName:'" + completeSingerName + '\'' +
                ", albumId:'" + albumId + '\'' +
                ", albumName:'" + albumName + '\'' +
                ", completeAlbumName:'" + completeAlbumName + '\'' +
                ", interval:" + interval +
                ", intervalMmss:'" + intervalMmss + '\'' +
                ", songMid:'" + songMid + '\'' +
                '}';
    }
}
