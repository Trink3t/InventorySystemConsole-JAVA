public class Service extends Item{
    private double rate;

    public Service(int ID, String name, String description, int par, int par1) {
        super(ID, name, description);
        setRate(rate);
    }

    public double getRate() { return rate; }
    
    public final void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateValue() {
        return rate;
    }

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
                calculateValue(),
                toReadableDateTime(getCreatedAt()),
                toReadableDateTime(getUpdatedAt())
        );
    }

}
