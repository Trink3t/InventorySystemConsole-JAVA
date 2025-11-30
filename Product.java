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

    /**
     * Sets the price of the product.
     * 
     * @param price the new price of the product
     * @throws IllegalArgumentException if the price is negative
     */
    public final void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the quantity of the product in the inventory.
     * 
     * @param quantity the new quantity of the product in the inventory
     * @throws IllegalArgumentException if the quantity is negative
     */
    public final void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the total value of the product in the inventory.
     * The total value is calculated by multiplying the price of the product
     * by the quantity of the product in the inventory.
     * 
     * @return the total value of the product in the inventory
     */
    @Override
    public double calculateValue() {
        return price * quantity;
    }

    /**
     * Returns a string representation of the product.
     * 
     * The string will be in the format:
     * [PRODUCT]
     * ID: <ID>
     * Name: <Name>
     * Description: <Description>
     * Price: <Price>
     * Quantity: <Quantity>
     * Value: <Value>
     * Created At: <Created At>
     * Updated At: <Updated At>
     * 
     * @return a string representation of the product
     */
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
