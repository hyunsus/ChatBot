package com.hyunsu.chatbot;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class KakaoTTS {
	public static void main(String[] args) {
		String openApiURL = "https://kakaoi-newtone-openapi.kakao.com/v1/synthesize";
		String REST_API_KEY = "b1188f7547025e5c1c4c9512dbe814f5";
		String data = "<speak> 그는 그렇게 말했습니다. \r\n"
				+ "<voice name=\"MAN_DIALOG_BRIGHT\">잘 지냈어? 나도 잘 지냈어.</voice> \r\n"
				+ "<voice name=\"WOMAN_DIALOG_BRIGHT\" speechStyle=\"SS_ALT_FAST_1\">금요일이 좋아요.</voice> </speak>";
		
        URL url;
        Integer responseCode = null;
        String responBody = null;
       
        try {
                url = new URL(openApiURL);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                con.setRequestProperty("Content-Type", "application/xml");
                con.setRequestProperty("Authorization", String.format("KakaoAK %s",REST_API_KEY));
                con.setRequestMethod("POST");
                con.setDoOutput(true);
 
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.write(data.getBytes("UTF-8"));
                wr.flush();
                wr.close();
 
                responseCode = con.getResponseCode();
                InputStream is = con.getInputStream();
                
                System.out.println("[responseCode] " + responseCode);
                System.out.println(is);
 
        } catch (MalformedURLException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
        
	}
}