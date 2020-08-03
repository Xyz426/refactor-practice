package com.twu.refactoring;

import java.util.List;

public class Order {
    String name;
    String addr;
    List<LineItem> list;

    public Order(String name, String addr, List<LineItem> list) {
        this.name = name;
        this.addr = addr;
        this.list = list;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return addr;
    }

    public List<LineItem> getLineItems() {
        return list;
    }
}
