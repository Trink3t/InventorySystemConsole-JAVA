public class ServiceBuilder extends ItemBuilder<Service, ServiceBuilder>{

    public ServiceBuilder(int ID) {
        validateField("ID", ID);
        this.item = new Service(ID, "", "", 0, 0);
    }

    public ServiceBuilder(Service service) {
        checkNullObj(service);
        this.item = service;
    }

    /**
     * Sets the name of the service.
     * 
     * @param name the new name of the service
     * @return this builder
     * @throws IllegalArgumentException if the name is null or empty
     */
    @Override
    public ServiceBuilder setName(String name) {
        validateField("Name", name);
        item.setName(name);
        return this;
    }

    /**
     * Sets the description of the service.
     * 
     * @param description the new description of the service
     * @return this builder
     */
    @Override
    public ServiceBuilder setDescription(String description) {
        validateField("Description", this);
        item.setDescription(description);
        return this;
    }

    /**
     * Sets the rate of the service.
     * 
     * @param rate the new rate of the service
     * @return this builder
     * @throws IllegalArgumentException if the rate is negative
     */
    public ServiceBuilder setRate(double rate) {
        validateField("Rate", rate);
        item.setRate(rate);
        return this;
    }

    /**
     * Validates a field in the service builder.
     * 
     * @param fieldName the name of the field to validate
     * @param value the value of the field to validate
     * 
     * @throws IllegalArgumentException if the field is invalid
     */
    @Override
    protected final void validateField(String fieldName, Object value) {
        super.validateField(fieldName, value);

        switch (fieldName) {
            case "Rate" -> {
                if (!(value instanceof Number num)) throw new IllegalArgumentException("Rate must be a number");
                double d = num.doubleValue();
                if (d < 0) throw new IllegalArgumentException("Rate cannot be negative");
            }
        }
    }

}
