public class Product extends Item {
    private double price;
    private int quantity;

    public Product(int ID, String name, String description, double price, int quantity) {
        super(ID, name, description);
        setPrice(price);
        setQuantity(quantity);
    }

    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public final void setPrice(double price) {
        this.price = price;
    }

    public final void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double calculateValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("""
                [PRODUCT]
                ID: %d
                Name: %s
                Description: %s
                Price: %.2f
                Quantity: %d
                Value: %.2f
                Created At: %s
                Updated At: %s
                """,
                getID(),
                getName(),
                getDescription(),
                getPrice(),
                getQuantity(),
                calculateValue(),
                toReadableDateTime(getCreatedAt()),
                toReadableDateTime(getUpdatedAt())
        );
    }

}
