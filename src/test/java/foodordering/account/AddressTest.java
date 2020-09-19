package foodordering.account;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AddressTest {


    @Test
    void givenAddressesShouldNotBeEmpty() {
        //given
        Address address1 = new Address("Piotrkowska","93");

        //when
        address1.getStreet();
        address1.getNumber();

        //then
        assertNotNull(address1.getStreet());
        assertNotNull(address1.getNumber());

    }
    @Test
    void givenNumberShouldBeLessThanEightCharacters(){
        //given
        Address address1 = new Address("Piotrkowska","93");

        //when
        address1.getStreet();
        address1.getNumber();

        //then
        assertThat(address1.getNumber().length(), lessThan(8));
    }

}