public class ProductBuilder extends ItemBuilder<Product, ProductBuilder> {

    public ProductBuilder(int ID) {
        validateField("ID", ID);
        this.item = new Product(ID, "", "", 0, 0);
    }

    public ProductBuilder(Product product) {
        checkNullObj(product);
        this.item = product;
    }

    @Override
    public ProductBuilder setName(String name) {
        validateField("Name", name);
        item.setName(name);
        return this;
    }

    @Override
    public ProductBuilder setDescription(String description) {
        validateField("Description", description);
        item.setDescription(description);
        return this;
    }

    public ProductBuilder setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        item.setPrice(price);
        return this;
    }

    public ProductBuilder setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        if (quantity % 1 != 0) throw new IllegalArgumentException("Quantity must be an integer");
        item.setQuantity(quantity);
        return this;
    }

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
