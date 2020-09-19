package foodordering.cart;

import foodordering.order.Order;
import java.util.ArrayList;
import java.util.List;

class Cart {

    private List<Order> orders = new ArrayList<>();

    List<Order> getOrders() {
        return orders;
    }

    void addOrderToCart(Order order) {
        this.orders.add(order);
    }

    void clearCart() {
        this.orders.clear();
    }

}