package oop.acdpsp.ch10isp.clientconstruction;

import oop.acdpsp.ch10isp.Delete;
import oop.acdpsp.ch10isp.Read;
import oop.acdpsp.ch10isp.Save;

public class OrderController {
    private Read<Order> reader;
    private Save<Order> saver;
    private Delete<Order> deleter;

    public OrderController(Read<Order> reader, Save<Order> saver, Delete<Order> deleter) {
        this.reader = reader;
        this.saver = saver;
        this.deleter = deleter;
    }

    public void createOrder(Order order) {
        saver.save(order);
    }

    public Order getSingleOrder(long id) {
        return reader.readOne(id);
    }

    public void updateOrder(Order order) {
        saver.save(order);
    }

    public void deleteOrder(Order order) {
        deleter.delete(order);
    }
}
