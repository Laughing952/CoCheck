package com.unistrong.business.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by edz on 2018/4/17.
 */

public class RequestMap implements Serializable{
    private Map<String,Object> map;

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public Map<String, Object> getMap() {

        return map;
    }
}
