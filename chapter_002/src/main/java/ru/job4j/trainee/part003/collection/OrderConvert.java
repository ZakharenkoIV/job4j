package ru.job4j.trainee.part003.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    public static HashMap<String, Order> listToHashMap(List<Order> inOrders) {
        HashMap<String, Order> outOrders = new HashMap<>();
        for (Order order : inOrders) {
            outOrders.put(order.getNumber(), order);
        }
        return outOrders;
    }
}
