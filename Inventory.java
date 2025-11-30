
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    /**
     * Prints out all items in the inventory.
     */
    public void listItems() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    /**
     * Prints out all items in the inventory of the given type.
     * 
     * @param type the type of item to print
     */
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

    /**
     * Adds an item to the inventory.
     * 
     * @param item the item to add
     * @throws IllegalArgumentException if the item has a duplicate ID
     */
    public void addItem(Item item) {
        if (hasDuplicateID(item.getID())) {
            throw new IllegalArgumentException("Duplicate ID detected: " + item.getID());
        }

        items.add(item);
    }


    /**
     * Retrieves an item from the inventory by its ID.
     * 
     * @param ID the ID of the item to retrieve
     * @return the item with the given ID, or null if no such item exists
     * @throws IllegalArgumentException if no item with the given ID exists
     */
    public Item getItem(int ID) {
        for (Item item : items) {
            if (item.getID() == ID) {
                return item;
            }
        }
        throw new IllegalArgumentException("Item not found!");
    }

    /**
     * Retrieves a list of all items in the inventory.
     * 
     * @return a list of all items in the inventory
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Checks if an item with the given ID already exists in the inventory.
     * 
     * @param ID the ID of the item to check
     * @return true if an item with the given ID already exists, false otherwise
     */
    private boolean hasDuplicateID(int ID) {
        for (Item item : items) {
            if (item.getID() == ID) {
                return true;
            }
        }
        return false;
    }

    /**
     * Updates an item in the inventory.
     * 
     * @param ID the ID of the item to update
     * @param item the new item to replace the old one
     * @throws IllegalArgumentException if no item with the given ID exists
     */
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
    
    /**
     * Removes an item from the inventory by its ID.
     * 
     * @param ID the ID of the item to remove
     * @throws IllegalArgumentException if no item with the given ID exists
     */
    public void removeItem(int ID) {
        boolean removed = items.removeIf(item -> item.getID() == ID);
        if (!removed) {
            throw new IllegalArgumentException("Item with ID " + ID + " not found");
        }
    }
}
