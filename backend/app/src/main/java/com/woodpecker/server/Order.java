package com.woodpecker.server;

import java.io.*;

public class Order implements Serializable, Cloneable {
    private String orderName;

    public Order(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderName(){
        return orderName;
    };

}
