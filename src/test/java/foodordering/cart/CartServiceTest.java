package foodordering.cart;

import foodordering.order.Order;
import foodordering.order.OrderStatus;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

class CartServiceTest {

     @Test
      void processCartShouldSendToPrepare() {

          //given
         CartHandler cartHandler = mock(CartHandler.class);
         CartService cartService = new CartService(cartHandler);
         Order order = new Order();
         Cart cart = new Cart();
         cart.addOrderToCart(order);

         given(cartHandler.canHandleCart(cart)).willReturn(true);

         //when
         Cart resultCart = cartService.processCart(cart);

         //then
         assertThat(resultCart.getOrders().get(0).getOrderStatus(), equalTo(OrderStatus.PREPARING));

      }

      @Test
      void processCartShouldNotSendToPrepare() {

          //given
          CartHandler cartHandler = mock(CartHandler.class);
          CartService cartService = new CartService(cartHandler);
          Order order = new Order();
          Cart cart = new Cart();
          cart.addOrderToCart(order);

          given(cartHandler.canHandleCart(cart)).willReturn(false);

          //when
          Cart resultCart = cartService.processCart(cart);

          //then
          assertThat(resultCart.getOrders().get(0).getOrderStatus(), equalTo(OrderStatus.REJECTED));

      }

    @Test
    void deliveryShouldBeFree() {

        //given
        CartHandler cartHandler = mock(CartHandler.class);
        Cart cart = new Cart();
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());

        given(cartHandler.isDeliveryFree(cart)).willCallRealMethod();

        //when
        boolean isDeliveryFree = cartHandler.isDeliveryFree(cart);

        //then
        assertTrue(isDeliveryFree);

    }
    @Test
    void deliveryShouldNotBeFree() {

        //given
        CartHandler cartHandler = mock(CartHandler.class);
        Cart cart = new Cart();
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());
        cart.addOrderToCart(new Order());

        given(cartHandler.isDeliveryFree(cart)).willCallRealMethod();

        //when
        boolean isDeliveryFree = cartHandler.isDeliveryFree(cart);

        //then
        assertFalse(isDeliveryFree);

    }
}