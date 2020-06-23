package indi.wwq.mickey.utils;

/**
 * @author wg
 */
public class JsonManager {
    public static String getJsonByUrl(String url) {
        return HttpRequestUtil.webContentByGet(url);
    }
    public static String strToJson(String str){
        str= str.replace("=",":");
        return str;
    }
}
