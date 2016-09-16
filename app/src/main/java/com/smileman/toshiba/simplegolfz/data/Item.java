package com.smileman.toshiba.simplegolfz.data;

import org.json.JSONObject;

/**
 * Created by hayatomoritani on 7/1/16.
 */
public class Item implements JSONPopulater {

    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void pupulate(JSONObject data) {
        condition = new Condition();
        condition.pupulate(data.optJSONObject("condition"));
    }
}
