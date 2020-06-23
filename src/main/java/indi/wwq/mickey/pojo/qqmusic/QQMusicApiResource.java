package indi.wwq.mickey.pojo.qqmusic;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * qq api资源类
 * @author wg
 */
@Configuration
@ConfigurationProperties(prefix = "api.music.resource")
@PropertySource(value = "classpath:api/qqapi.properties")
public class QQMusicApiResource {
private String search;
private String top;
private String random;
private String playLinkHead;
private String playLinkTail;

    public String getPlayLinkHead() {
        return playLinkHead;
    }

    public void setPlayLinkHead(String playLinkHead) {
        this.playLinkHead = playLinkHead;
    }

    public String getPlayLinkTail() {
        return playLinkTail;
    }

    public void setPlayLinkTail(String playLinkTail) {
        this.playLinkTail = playLinkTail;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getRandom() {
        return random;
    }

    public void setRandom(String random) {
        this.random = random;
    }


}
