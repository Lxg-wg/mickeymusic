package indi.wwq.mickey.pojo.qqmusic;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * 根据api接口返回的json数据生成的实体类
 * @author wg
 */
public class QQTopSongJson {
    private int code;
    private int color;
    private int comment_num;
    private int cur_song_num;
    private String date;
    private String day_of_year;
    private int song_begin;
    private TopinfoBean topinfo;
    private int total_song_num;
    private String update_time;
    private List<SonglistBean> songlist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getCur_song_num() {
        return cur_song_num;
    }

    public void setCur_song_num(int cur_song_num) {
        this.cur_song_num = cur_song_num;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay_of_year() {
        return day_of_year;
    }

    public void setDay_of_year(String day_of_year) {
        this.day_of_year = day_of_year;
    }

    public int getSong_begin() {
        return song_begin;
    }

    public void setSong_begin(int song_begin) {
        this.song_begin = song_begin;
    }

    public TopinfoBean getTopinfo() {
        return topinfo;
    }

    public void setTopinfo(TopinfoBean topinfo) {
        this.topinfo = topinfo;
    }

    public int getTotal_song_num() {
        return total_song_num;
    }

    public void setTotal_song_num(int total_song_num) {
        this.total_song_num = total_song_num;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public List<SonglistBean> getSonglist() {
        return songlist;
    }

    public void setSonglist(List<SonglistBean> songlist) {
        this.songlist = songlist;
    }

    public static class TopinfoBean implements Serializable {
        private String ListName;
        private String MacDetailPicUrl;
        private String MacListPicUrl;
        private String UpdateType;
        private String albuminfo;
        private String headPic_v12;
        private String info;
        private int listennum;
        private String pic;
        private String picDetail;
        private String pic_album;
        private String pic_h5;
        private String pic_v11;
        private String pic_v12;
        private String topID;
        private String type;

        public String getListName() {
            return ListName;
        }

        public void setListName(String ListName) {
            this.ListName = ListName;
        }

        public String getMacDetailPicUrl() {
            return MacDetailPicUrl;
        }

        public void setMacDetailPicUrl(String MacDetailPicUrl) {
            this.MacDetailPicUrl = MacDetailPicUrl;
        }

        public String getMacListPicUrl() {
            return MacListPicUrl;
        }

        public void setMacListPicUrl(String MacListPicUrl) {
            this.MacListPicUrl = MacListPicUrl;
        }

        public String getUpdateType() {
            return UpdateType;
        }

        public void setUpdateType(String UpdateType) {
            this.UpdateType = UpdateType;
        }

        public String getAlbuminfo() {
            return albuminfo;
        }

        public void setAlbuminfo(String albuminfo) {
            this.albuminfo = albuminfo;
        }

        public String getHeadPic_v12() {
            return headPic_v12;
        }

        public void setHeadPic_v12(String headPic_v12) {
            this.headPic_v12 = headPic_v12;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public int getListennum() {
            return listennum;
        }

        public void setListennum(int listennum) {
            this.listennum = listennum;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getPicDetail() {
            return picDetail;
        }

        public void setPicDetail(String picDetail) {
            this.picDetail = picDetail;
        }

        public String getPic_album() {
            return pic_album;
        }

        public void setPic_album(String pic_album) {
            this.pic_album = pic_album;
        }

        public String getPic_h5() {
            return pic_h5;
        }

        public void setPic_h5(String pic_h5) {
            this.pic_h5 = pic_h5;
        }

        public String getPic_v11() {
            return pic_v11;
        }

        public void setPic_v11(String pic_v11) {
            this.pic_v11 = pic_v11;
        }

        public String getPic_v12() {
            return pic_v12;
        }

        public void setPic_v12(String pic_v12) {
            this.pic_v12 = pic_v12;
        }

        public String getTopID() {
            return topID;
        }

        public void setTopID(String topID) {
            this.topID = topID;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    public static class SonglistBean implements Serializable {
        private String Franking_value;
        private String cur_count;
        private DataBean data;
        private String in_count;
        private String old_count;

        public String getFranking_value() {
            return Franking_value;
        }

        public void setFranking_value(String Franking_value) {
            this.Franking_value = Franking_value;
        }

        public String getCur_count() {
            return cur_count;
        }

        public void setCur_count(String cur_count) {
            this.cur_count = cur_count;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getIn_count() {
            return in_count;
        }

        public void setIn_count(String in_count) {
            this.in_count = in_count;
        }

        public String getOld_count() {
            return old_count;
        }

        public void setOld_count(String old_count) {
            this.old_count = old_count;
        }

        public static class DataBean implements Serializable {
            private String albumdesc;
            private int albumid;
            private String albummid;
            private String albumname;
            private int alertid;
            private int belongCD;
            private int cdIdx;
            private int interval;
            private int isonly;
            private String label;
            private int msgid;
            private PayBean pay;
            private PreviewBean preview;
            private int rate;
            private int size128;
            private int size320;
            private int size5_1;
            private int sizeape;
            private int sizeflac;
            private int sizeogg;
            private int songid;
            private String songmid;
            private String songname;
            private String songorig;
            private int songtype;
            private String strMediaMid;
            private int stream;
            @SerializedName("switch")
            private int switchX;
            private int type;
            private String vid;
            private List<SingerBean> singer;

            public String getAlbumdesc() {
                return albumdesc;
            }

            public void setAlbumdesc(String albumdesc) {
                this.albumdesc = albumdesc;
            }

            public int getAlbumid() {
                return albumid;
            }

            public void setAlbumid(int albumid) {
                this.albumid = albumid;
            }

            public String getAlbummid() {
                return albummid;
            }

            public void setAlbummid(String albummid) {
                this.albummid = albummid;
            }

            public String getAlbumname() {
                return albumname;
            }

            public void setAlbumname(String albumname) {
                this.albumname = albumname;
            }

            public int getAlertid() {
                return alertid;
            }

            public void setAlertid(int alertid) {
                this.alertid = alertid;
            }

            public int getBelongCD() {
                return belongCD;
            }

            public void setBelongCD(int belongCD) {
                this.belongCD = belongCD;
            }

            public int getCdIdx() {
                return cdIdx;
            }

            public void setCdIdx(int cdIdx) {
                this.cdIdx = cdIdx;
            }

            public int getInterval() {
                return interval;
            }

            public void setInterval(int interval) {
                this.interval = interval;
            }

            public int getIsonly() {
                return isonly;
            }

            public void setIsonly(int isonly) {
                this.isonly = isonly;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public int getMsgid() {
                return msgid;
            }

            public void setMsgid(int msgid) {
                this.msgid = msgid;
            }

            public PayBean getPay() {
                return pay;
            }

            public void setPay(PayBean pay) {
                this.pay = pay;
            }

            public PreviewBean getPreview() {
                return preview;
            }

            public void setPreview(PreviewBean preview) {
                this.preview = preview;
            }

            public int getRate() {
                return rate;
            }

            public void setRate(int rate) {
                this.rate = rate;
            }

            public int getSize128() {
                return size128;
            }

            public void setSize128(int size128) {
                this.size128 = size128;
            }

            public int getSize320() {
                return size320;
            }

            public void setSize320(int size320) {
                this.size320 = size320;
            }

            public int getSize5_1() {
                return size5_1;
            }

            public void setSize5_1(int size5_1) {
                this.size5_1 = size5_1;
            }

            public int getSizeape() {
                return sizeape;
            }

            public void setSizeape(int sizeape) {
                this.sizeape = sizeape;
            }

            public int getSizeflac() {
                return sizeflac;
            }

            public void setSizeflac(int sizeflac) {
                this.sizeflac = sizeflac;
            }

            public int getSizeogg() {
                return sizeogg;
            }

            public void setSizeogg(int sizeogg) {
                this.sizeogg = sizeogg;
            }

            public int getSongid() {
                return songid;
            }

            public void setSongid(int songid) {
                this.songid = songid;
            }

            public String getSongmid() {
                return songmid;
            }

            public void setSongmid(String songmid) {
                this.songmid = songmid;
            }

            public String getSongname() {
                return songname;
            }

            public void setSongname(String songname) {
                this.songname = songname;
            }

            public String getSongorig() {
                return songorig;
            }

            public void setSongorig(String songorig) {
                this.songorig = songorig;
            }

            public int getSongtype() {
                return songtype;
            }

            public void setSongtype(int songtype) {
                this.songtype = songtype;
            }

            public String getStrMediaMid() {
                return strMediaMid;
            }

            public void setStrMediaMid(String strMediaMid) {
                this.strMediaMid = strMediaMid;
            }

            public int getStream() {
                return stream;
            }

            public void setStream(int stream) {
                this.stream = stream;
            }

            public int getSwitchX() {
                return switchX;
            }

            public void setSwitchX(int switchX) {
                this.switchX = switchX;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getVid() {
                return vid;
            }

            public void setVid(String vid) {
                this.vid = vid;
            }

            public List<SingerBean> getSinger() {
                return singer;
            }

            public void setSinger(List<SingerBean> singer) {
                this.singer = singer;
            }

            public static class PayBean implements Serializable {
                private int payalbum;
                private int payalbumprice;
                private int paydownload;
                private int payinfo;
                private int payplay;
                private int paytrackmouth;
                private int paytrackprice;
                private int timefree;

                public int getPayalbum() {
                    return payalbum;
                }

                public void setPayalbum(int payalbum) {
                    this.payalbum = payalbum;
                }

                public int getPayalbumprice() {
                    return payalbumprice;
                }

                public void setPayalbumprice(int payalbumprice) {
                    this.payalbumprice = payalbumprice;
                }

                public int getPaydownload() {
                    return paydownload;
                }

                public void setPaydownload(int paydownload) {
                    this.paydownload = paydownload;
                }

                public int getPayinfo() {
                    return payinfo;
                }

                public void setPayinfo(int payinfo) {
                    this.payinfo = payinfo;
                }

                public int getPayplay() {
                    return payplay;
                }

                public void setPayplay(int payplay) {
                    this.payplay = payplay;
                }

                public int getPaytrackmouth() {
                    return paytrackmouth;
                }

                public void setPaytrackmouth(int paytrackmouth) {
                    this.paytrackmouth = paytrackmouth;
                }

                public int getPaytrackprice() {
                    return paytrackprice;
                }

                public void setPaytrackprice(int paytrackprice) {
                    this.paytrackprice = paytrackprice;
                }

                public int getTimefree() {
                    return timefree;
                }

                public void setTimefree(int timefree) {
                    this.timefree = timefree;
                }
            }

            public static class PreviewBean implements Serializable {
                private int trybegin;
                private int tryend;
                private int trysize;

                public int getTrybegin() {
                    return trybegin;
                }

                public void setTrybegin(int trybegin) {
                    this.trybegin = trybegin;
                }

                public int getTryend() {
                    return tryend;
                }

                public void setTryend(int tryend) {
                    this.tryend = tryend;
                }

                public int getTrysize() {
                    return trysize;
                }

                public void setTrysize(int trysize) {
                    this.trysize = trysize;
                }
            }

            public static class SingerBean implements Serializable {
                private int id;
                private String mid;
                private String name;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }
    }
}
