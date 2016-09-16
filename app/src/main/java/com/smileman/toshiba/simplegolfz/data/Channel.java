package com.smileman.toshiba.simplegolfz.data;

import org.json.JSONObject;

/**
 * Created by hayatomoritani on 7/1/16.
 */
public class Channel implements JSONPopulater {

    private Units units;
    private  Item item;

    public Units getUnits() {
        return units;
    }

    public Item getItem() {
        return item;
    }

    @Override
    public void pupulate(JSONObject data) {

        units = new Units();
        units.pupulate(data.optJSONObject("units"));

        item = new Item();
        item.pupulate(data.optJSONObject("item"));

    }
}
