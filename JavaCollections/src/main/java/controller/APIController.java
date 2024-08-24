/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import model.Auth;


/**
 *
 * @author evelinsteiger
 */
public class APIController {
    static int successCode = 200;
    
    private static String filter;
    
    public static void setFilter(String filter) {
        APIController.filter = filter;
    }
    
    private static Auth auth;
    
    static void setAuth(Auth auth) {
        APIController.auth = auth;
    }
    
    static String jsonToString (BufferedReader buffereReader) throws IOException {
        String response, data = "";
        
        while ((response = buffereReader.readLine()) != null) {
            data += response;
        }
        
        return data;
    }
    
    static Map<Integer, String> jsonArrayToString (BufferedReader buffereReader) throws IOException {
        String response, data = "";
       
        Map<Integer, String> map = new HashMap<>();
  
        int i = 0;
        
        while ((response = buffereReader.readLine()) != null) {
            if ("[".equals(response.trim()) && data.isEmpty()) {
                buffereReader.skip(1);
            } else {
                if ("{".equals(response.trim()) && data.trim().replaceAll("\\s","").endsWith("]},")) {
                    map.put(i, data.substring(0, data.length() - 1));
                    
                    data = "";
                    i++;           
                }
                
                data += response;

                map.put(i, data);
            }
        }

        
        map.put(i, data.substring(0, data.length() - 1));

        return map;
    }
    
    public static boolean handleAuth() throws Exception {
        String baseUrl = "https://id.twitch.tv/oauth2/token?" + 
                     "client_id=zu9lflw6vehnews02st1s8np1jqqw1&" + 
                     "client_secret=pyg2t66wim2tjctta5bpnuqd19meks&" + 
                     "grant_type=client_credentials";

        try {
            URL url = new URL(baseUrl);
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("POST");
            
            if (conn.getResponseCode() != successCode) {
                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
            }
            
            BufferedReader response = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String data = jsonToString(response);
            
            Gson gson = new Gson();
            Auth auth = gson.fromJson(data, Auth.class);
            
            setAuth(auth);
            
            return true;
        } catch (IOException | RuntimeException e) {
            throw new Exception("ERRO: " + e);
        }
    }
    
    public static Map<Integer, String> fetchGames(String filter) throws Exception {   
        String baseUrl = "https://api.igdb.com/v4/games/?" + 
                     "limit=2&" + 
                     "search=" + filter + "&" +
                     "fields=name,first_release_date,genres.name,total_rating,cover.image_id,platforms.name"; 

        try {
            URL url = new URL(baseUrl);
            
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + auth.getAccessToken());
            conn.setRequestProperty("Client-ID", "zu9lflw6vehnews02st1s8np1jqqw1");
            conn.setRequestProperty("Accept", "application/json");
            
            if (conn.getResponseCode() != successCode) {
                throw new RuntimeException("HTTP error code : " + conn.getResponseCode());
            }
          
            BufferedReader response = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            
            Map<Integer, String> data = jsonArrayToString(response);

            return data;
        } catch (IOException | RuntimeException e) {
            throw new Exception("ERRO: " + e);
        }    
    }     
}
