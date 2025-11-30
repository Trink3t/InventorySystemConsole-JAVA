public abstract class ItemBuilder<T extends Item, B extends ItemBuilder<T,B>> {
    protected T item;

    protected final void checkNullObj(T item) {
        if(item == null) throw new IllegalArgumentException("Item cannot be null");
    }

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

    public T build() {
        return item;
    }
}