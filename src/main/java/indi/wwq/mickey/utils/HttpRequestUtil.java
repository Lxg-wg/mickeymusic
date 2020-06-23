package indi.wwq.mickey.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author wg
 */
public class HttpRequestUtil {
    public static String webContentByGet(String requestUrl)  {
        StringBuilder buffer = new StringBuilder();
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            if(urlConnection.getResponseCode()==200){
                 is = urlConnection.getInputStream();
                 isr = new InputStreamReader(is);
                 br = new BufferedReader(isr);
                String str;
                while ((str = br.readLine())!=null){
                    buffer.append(str);
                }
                br.close();
                isr.close();
                is.close();
        }
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
