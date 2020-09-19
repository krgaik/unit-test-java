package foodordering.account;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test
    void newlyCreatedAccountShouldNotBeActive() {

        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive());
    }

    @Test
    void activatedAccountShouldHaveActiveFlagSet() {

        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive());

    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {

        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();

        //then
        assertNull(address);
        assertThat(address, nullValue());

    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {

        //given
        Address address = new Address("Piotrkowska", "93");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultAddress);
    }

    @Test
    void newAccountWithNotNullAddressShouldBeActive() {

        //given
        Address address = new Address("Piotrkowska", "93/6");

        //when
        Account account = new Account(address);

        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });

    }

    @Test
    void invalidEmailShouldThrowException() {

        //given
        Account account = new Account();

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrongEmail"));

    }

    @Test
    void validEmailShouldBeSet() {
        //given
        Account account = new Account();

        //when
        account.setEmail("test@test.pl");

        //then
        assertThat(account.getEmail(), is("test@test.pl"));
    }

}