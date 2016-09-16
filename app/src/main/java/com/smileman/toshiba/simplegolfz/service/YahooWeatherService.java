package com.smileman.toshiba.simplegolfz.service;

import android.net.Uri;
import android.os.AsyncTask;

import com.smileman.toshiba.simplegolfz.data.Channel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by hayatomoritani on 7/1/16.
 */
public class YahooWeatherService {

    private String location;
    private CallBack callBack;
    private Exception error;

    public YahooWeatherService(CallBack callBack){this.callBack = callBack;}


    public void weather(String loc){
        this.location = loc;
        new AsyncTask<String,Void,String>(){

            @Override
            protected String doInBackground(String... strings) {
                String YQL = String.format("select * from weather.forecast where woeid in (select woeid from geo.places(1) where text='%s')and u='c'",strings[0]);
                String endpoint = String.format("https://query.yahooapis.com/v1/public/yql?q=%s&format=json", Uri.encode(YQL));

                try {
                    URL url = new URL(endpoint);
                    URLConnection connection = url.openConnection();
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder builder = new StringBuilder();
                    String line;
                    while ((line =reader.readLine())!=null){
                        builder.append(line);
                    }
                    return builder.toString();


                } catch (Exception e) {
                    error = e;
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                if (s == null&&error !=null){
                    callBack.serviceFailure(error);
                    return;
                }
                try {
                    JSONObject data = new JSONObject(s);
                    JSONObject result = data.optJSONObject("query");
                    int count = result.optInt("count");
                    if (count==0){
                        callBack.serviceFailure(new LocationWeatherException("location not found"));
                        return;
                    }
                    Channel channel = new Channel();
                    channel.pupulate(result.optJSONObject("results").optJSONObject("channel"));
                    callBack.serviceSuccess(channel);
                } catch (JSONException e) {
                    callBack.serviceFailure(e);
                }

            }
        }.execute(location);
    }
    public class LocationWeatherException extends Exception{
        public LocationWeatherException(String message){super(message);}
    }
}
