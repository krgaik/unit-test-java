package foodordering.account;


class Address {

    private String street;
    private String number;


    Address(String street, String number) {
        this.street = street;
        this.number = number;
    }


    public String getStreet() {
        return street;
    }


    public String getNumber() {
        return number;
    }
}