public class ProductBuilder extends ItemBuilder<Product, ProductBuilder> {

    public ProductBuilder(int ID) {
        validateField("ID", ID);
        this.item = new Product(ID, "", "", 0, 0);
    }

    public ProductBuilder(Product product) {
        checkNullObj(product);
        this.item = product;
    }

    /**
     * Sets the name of the product.
     * 
     * @param name the new name of the product
     * @return this builder
     */
    @Override
    public ProductBuilder setName(String name) {
        validateField("Name", name);
        item.setName(name);
        return this;
    }


    /**
     * Sets the description of the product.
     * 
     * @param description the new description of the product
     * @return this builder
     */
    @Override
    public ProductBuilder setDescription(String description) {
        validateField("Description", description);
        item.setDescription(description);
        return this;
    }

    /**
     * Sets the price of the product.
     * 
     * @param price the new price of the product
     * @return this builder
     * @throws IllegalArgumentException if the price is negative
     */
    public ProductBuilder setPrice(double price) {
        validateField("Price", item);
        item.setPrice(price);
        return this;
    }

    /**
     * Sets the quantity of the product.
     * 
     * @param quantity the new quantity of the product
     * @return this builder
     * @throws IllegalArgumentException if the quantity is negative
     */
    public ProductBuilder setQuantity(int quantity) {
        validateField("Quantity", item);
        item.setQuantity(quantity);
        return this;
    }

    /**
     * Validates a field in the product builder.
     * 
     * @param fieldName the name of the field to validate
     * @param value the value of the field to validate
     * 
     * @throws IllegalArgumentException if the field is invalid
     */
    @Override
    protected void validateField(String fieldName, Object value) {
        super.validateField(fieldName, value);

        switch (fieldName) {
            case "Price" -> {
                if (!(value instanceof Number)) throw new IllegalArgumentException("Price must be a number");
                double d = ((Number) value).doubleValue();
                if (d < 0) throw new IllegalArgumentException("Price cannot be negative");
            }
            case "Quantity" -> {
                if (!(value instanceof Number)) throw new IllegalArgumentException("Quantity must be a number");
                double d = ((Number) value).doubleValue();
                if (d < 0) throw new IllegalArgumentException("Quantity cannot be negative");
                if (d % 1 != 0) throw new IllegalArgumentException("Quantity must be an integer");
            }
        }
    }
}
