package com.smileman.toshiba.simplegolfz.data;

import org.json.JSONObject;

/**
 * Created by hayatomoritani on 7/1/16.
 */
public class Units implements JSONPopulater {

    private String tempUnit;

    public String getTempUnit() {
        return tempUnit;
    }

    @Override
    public void pupulate(JSONObject data) {
        tempUnit = data.optString("temperature");

    }
}
