package indi.wwq.mickey.utils;

/**
 * @author wg
 */
public class ProcessingFormat {
    /**
     * 将s转换成mm:ss格式
     */
    public static String toMmss(int time) {
        int m = time / 60;
        int s = time % 60;
        return (m > 9 ? m : "0" + m) + ":" + (s > 9 ? s : "0" + s);
    }
    /**
     * 截取过长的字符串
     */
    public static String interceptionTooLong(String str,int len){
        if(str.length()>len){
            return str.substring(0,len)+"...";
        }
        return str;
    }
}
