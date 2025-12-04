public class Service extends Item{
    private double rate;

    public Service(int ID, String name, String description, double rate) {
        super(ID, name, description);
        setRate(rate);
    }

    public double getRate() { return rate; }
    
    /**
     * Sets the rate of the service.
     * 
     * @param rate the new rate of the service
     * @throws IllegalArgumentException if the rate is negative
     */
    public final void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * Calculates the value of the service.
     * 
     * The value of a service is its rate.
     * 
     * @return the value of the service
     */
    @Override
    public double calculateValue() {
        return rate;
    }

    /**
     * Returns a string representation of the service.
     * 
     * @return a string representation of the service in the format
     * "[SERVICE]\nID: %d\nName: %s\nDescription: %s\nRate: %.2f\nCreated At: %s\nUpdated At: %s"
     */
    @Override
    public String toString() {
        return String.format("""
                [SERVICE]
                ID: %d
                Name: %s
                Description: %s
                Rate: %.2f
                Created At: %s
                Updated At: %s
                """,
                getID(),
                getName(),
                getDescription(),
                getRate(),
                toReadableDateTime(getCreatedAt()),
                toReadableDateTime(getUpdatedAt())
        );
    }

}
