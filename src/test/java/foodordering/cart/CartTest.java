package foodordering.cart;

import foodordering.order.Order;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


class CartTest {

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart() {

        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), hasSize(1));
    }

    @Test
    void cartShouldBeEmptyAfterClearingIt(){
        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);
        cart.clearCart();

        //then
        assertThat(cart.getOrders(), hasSize(0));
    }
}