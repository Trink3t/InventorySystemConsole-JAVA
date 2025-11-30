public class ServiceBuilder extends ItemBuilder<Service, ServiceBuilder>{

    public ServiceBuilder(int ID) {
        validateField("ID", ID);
        this.item = new Service(ID, "", "", 0, 0);
    }

    public ServiceBuilder(Service service) {
        checkNullObj(service);
        this.item = service;
    }

    @Override
    public ServiceBuilder setName(String name) {
        validateField("Name", name);
        item.setName(name);
        return this;
    }

    @Override
    public ServiceBuilder setDescription(String description) {
        validateField("Description", this);
        item.setDescription(description);
        return this;
    }

    public ServiceBuilder setRate(double rate) {
        validateField("Rate", rate);
        item.setRate(rate);
        return this;
    }

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
