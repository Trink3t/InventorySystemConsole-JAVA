public abstract class ItemBuilder<T extends Item, B extends ItemBuilder<T,B>> {
    protected T item;

    /**
     * Checks if the given item is null, and throws an IllegalArgumentException if it is.
     * 
     * @param item the item to check
     * @throws IllegalArgumentException if the item is null
     */
    protected final void checkNullObj(T item) {
        if(item == null) throw new IllegalArgumentException("Item cannot be null");
    }

    /**
     * Validates a field in the item.
     * 
     * @param fieldName the name of the field to validate
     * @param value the value of the field to validate
     * @throws IllegalArgumentException if the field is invalid
     */
    protected void validateField(String fieldName, Object value) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null");
        }

        switch (fieldName) {
            case "ID" -> {
                if (!(value instanceof Number num)) {
                    throw new IllegalArgumentException(fieldName + " must be a number");
                }
                double d = num.doubleValue();
                if (d % 1 != 0) {
                    throw new IllegalArgumentException(fieldName + " must be an integer");
                }
                if (d < 0) {
                    throw new IllegalArgumentException(fieldName + " cannot be negative");
                }
            }

            case "Name" -> {
                if (!(value instanceof String str)) {
                    throw new IllegalArgumentException(fieldName + " must be a string");
                }
                if (str.trim().isEmpty()) {
                    throw new IllegalArgumentException(fieldName + " cannot be empty");
                }
            }
        }
    }

    public abstract B setName(String name);
    public abstract B setDescription(String description);

    /**
     * Builds the item.
     * 
     * @return the built item
     */
    public T build() {
        return item;
    }
}