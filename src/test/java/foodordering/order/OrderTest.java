package foodordering.order;

import foodordering.meal.Meal;
import foodordering.order.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class OrderTest {

    private Order order;

    @BeforeEach
    void initializeOrder() {
        order = new Order();
    }

    @AfterEach
    void cleanUp() {
        order.cancel();
    }
    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder() {
        //then
        assertThat(order.getMeals(), empty());
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {

        //given
        Meal meal = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        //when
        order.addMealToOrder(meal);
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals(), hasSize(2));
    }

    @Test
    void removingMealFromOrderShouldDecreaseOrderSize() {

        //given
        Meal meal = new Meal(15, "Burger");

        //when
        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);

        //then
        assertThat(order.getMeals(), hasSize(0));

    }

    @Test
    void mealsShouldBeInCorrectOrderAfterAddingThemToOrder() {

        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        //then
        assertThat(order.getMeals().get(0), is(meal1));
        assertThat(order.getMeals().get(1), is(meal2));

    }
    @Test
    void listOfMelasShouldBeEmptyAfterCancellation(){
        //given
        Meal meal1 = new Meal(15, "Burger");
        Meal meal2 = new Meal(5, "Sandwich");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        order.cancel();

        //then
        assertThat(order.getMeals(), hasSize(0));

    }
    @Test
    void testIfTotalPriceReturnsCorrectPrice(){
        //given
        Meal meal1 = new Meal(15,3, "Burger");
        Meal meal2 = new Meal(5,4, "Sandwich");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);
        int totalPrice = order.totalPrice();

        //then
        assertThat(totalPrice, equalTo(65));
    }

    @Test
    void throwsExceptionWhenPriceBelowZero(){
        Meal meal1 = new Meal(-1,3, "Burger");
        Meal meal2 = new Meal(-1,4, "Sandwich");

        //when
        order.addMealToOrder(meal1);
        order.addMealToOrder(meal2);

        //then
        assertThrows(IllegalStateException.class, () -> order.totalPrice());

    }

    @Test
    void orderStatusShouldBeChanged(){
        //given
        //when
        order.changeOrderStatus(OrderStatus.PREPARING);

        //then
        assertThat(order.getOrderStatus(), equalTo(OrderStatus.PREPARING));
    }
}
