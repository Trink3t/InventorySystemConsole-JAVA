
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Item {
    private int ID;
    private String name;
    private String description;
    private Date updatedAt;
    
    private final Date createdAt = new Date();
    
    public Item(int ID, String name, String description) {
        setID(ID);
        setName(name);
        setDescription(description);
        setUpdatedAt();
    }

    public int getID() { return ID; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Date getCreatedAt() { return createdAt; }
    public Date getUpdatedAt() { return updatedAt; }

    protected String toReadableDateTime(Date date) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy | hh:mm:ss a");

        return dateFormatter.format(date);
    }

    public final void setID(int ID) {
        this.ID = ID;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final void setDescription(String description) {
        this.description = description;
    }

    public final void setUpdatedAt() {
        this.updatedAt = new Date();
    }

    public abstract double calculateValue();

    


}
