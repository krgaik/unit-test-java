package foodordering.meal;

public class Meal {

    private int price;
    private int quantity;
    private String name;

    public Meal() {
    }

    Meal(int price) {
        this.price = price;
    }

    public Meal(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Meal(int price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    int getQuantity() {
        return quantity;
    }

    int getDiscountedPrice(int discount) {

        if(discount > this.price) {
            throw new IllegalArgumentException("Discount cannot be higher than the price!");
        }

        return this.price - discount;
    }

    public int sumPrice() {
        return getPrice() * getQuantity();
    }

    public String getName() {
        return this.name;
    }

}