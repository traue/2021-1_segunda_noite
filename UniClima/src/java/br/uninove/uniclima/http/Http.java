package br.uninove.uniclima.http;

import br.uninove.uniclima.tempo.Tempo;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Http {
    
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while((cp = rd.read()) != -1) {
            sb.append((char)cp);
        }

        return sb.toString();
    }
    
    public static Tempo getClima(String cidade) {
        try {
            
            Tempo tempo;
            String charset = StandardCharsets.UTF_8.name();
            String url = "http://api.openweathermap.org/data/2.5/weather";
            String appid = "XXXX"; //COLOCAR A SUA CHAVE DE API AQUI
            String units = "metric";
            String lang = "pt_br";
            
            String query = String.format("q=%s&APPID=%s&units=%s&lang=%s",
                    URLEncoder.encode(cidade, charset),
                    URLEncoder.encode(appid, charset),
                    URLEncoder.encode(units, charset),
                    URLEncoder.encode(lang, charset));
            
            URLConnection conn = new URL(url + "?" + query).openConnection();
            
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept-Charset", charset);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
                       
            try(InputStream response = conn.getInputStream()) {
                BufferedReader buffer = new BufferedReader(new InputStreamReader(response, 
                        Charset.forName("UTF-8")));
                String json = readAll(buffer);
                Gson gson = new Gson();
                tempo = gson.fromJson(json, Tempo.class);
            }
            
            return tempo;
            
        } catch(IOException | JsonSyntaxException e) {
            
        }
        
        return null;
    } 
    
}
