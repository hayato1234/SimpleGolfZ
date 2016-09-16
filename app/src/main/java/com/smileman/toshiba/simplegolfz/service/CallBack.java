package com.smileman.toshiba.simplegolfz.service;

import com.smileman.toshiba.simplegolfz.data.Channel;

/**
 * Created by hayatomoritani on 7/1/16.
 */
public interface CallBack {
    void serviceSuccess(Channel channel);
    void serviceFailure(Exception e);
}
