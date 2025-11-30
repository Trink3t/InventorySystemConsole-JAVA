
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void listItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void listItemsByType(ItemType type) {
        for (Item item : items) {
            if (type.equals(ItemType.PRODUCT) && item instanceof Product) {
                System.out.println(item);
            }

            if (type.equals(ItemType.SERVICE) && item instanceof Service) {
                System.out.println(item);
            }
        }
    }

    public void addItem(Item item) {
        if (hasDuplicateID(item.getID())) {
            throw new IllegalArgumentException("Duplicate ID detected: " + item.getID());
        }

        items.add(item);
    }


    public Item getItem(int ID) {
        for (Item item : items) {
            if (item.getID() == ID) {
                return item;
            }
        }
        throw new IllegalArgumentException("Item not found!");
    }

    public List<Item> getItems() {
        return items;
    }

    private boolean hasDuplicateID(int ID) {
        for (Item item : items) {
            if (item.getID() == ID) {
                return true;
            }
        }
        return false;
    }

    public void updateItem(int ID, Item item) {

        boolean updated = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getID() == ID) {
                items.set(i, item);
                updated = true;
                break;
            }
        }

        if (!updated) {
            throw new IllegalArgumentException("Item with ID " + ID + " not found");
        }
    }
    
    public void removeItem(int ID) {
        boolean removed = items.removeIf(item -> item.getID() == ID);
        if (!removed) {
            throw new IllegalArgumentException("Item with ID " + ID + " not found");
        }
    }
}
