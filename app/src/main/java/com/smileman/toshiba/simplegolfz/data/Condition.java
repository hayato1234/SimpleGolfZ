package com.smileman.toshiba.simplegolfz.data;

import org.json.JSONObject;

/**
 * Created by hayatomoritani on 7/1/16.
 */
public class Condition implements JSONPopulater {

    private int temp;
    private String text;

    public int getTemp() {
        return temp;
    }

    public String getText() {
        return text;
    }

    @Override
    public void pupulate(JSONObject data) {
        temp = data.optInt("temp");
        text = data.optString("text");
    }
}
