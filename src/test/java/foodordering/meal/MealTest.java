package foodordering.meal;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {

        //given
        Meal meal = new Meal(35);

        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertEquals(28, discountedPrice);
    }



    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice() {

        //given
        Meal meal = new Meal(8, "Soup");

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountedPrice(40));

    }

    @Test
    void testMealSumPrice() {

        //given
        Meal meal = mock(Meal.class);

        given(meal.getPrice()).willReturn(15);
        given(meal.getQuantity()).willReturn(3);

        given(meal.sumPrice()).willCallRealMethod();

        //when
        int result = meal.sumPrice();

        //then
        assertThat(result, equalTo(45));

    }

}