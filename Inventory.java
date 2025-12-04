
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    /**
     * Prints out all items in the inventory.
     */
    public Inventory() {
        initializeInventory();
    }

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
    public boolean removeItem(int ID) {
        boolean removed = items.removeIf(item -> item.getID() == ID);
        if (!removed) {
            throw new IllegalArgumentException("Item with ID " + ID + " not found");
        }

        return true;
    }

    private void initializeInventory() {
        items.add(new Product(0, "Handmade Tote Bag", "Eco–friendly woven bag", 230, 18));
        items.add(new Product(1, "Crochet Keychain", "Mini plush keychain", 75, 40));
        items.add(new Product(2, "Resin Coaster Set", "4-piece decorative coasters", 320, 12));
        items.add(new Product(3, "Aroma Candle", "Lavender scented candle", 150, 25));
        items.add(new Product(4, "Beaded Bracelet", "Customizable beaded accessory", 60, 35));
        items.add(new Product(5, "Knitted Beanie", "Warm winter beanie", 180, 20));
        items.add(new Product(6, "Phone Strap", "Handmade macrame strap", 90, 28));
        items.add(new Product(7, "Wooden Picture Frame", "Rustic handmade frame", 250, 10));
        items.add(new Product(8, "Crochet Pouch", "Small multipurpose pouch", 120, 22));
        items.add(new Product(9, "Mini Desk Plant Decor", "Handcrafted resin plant", 95, 30));
        items.add(new Service(10, "Custom Invitation Card", "Personalized digital layout", 20));
        items.add(new Service(11, "Gift Wrapping Service", "Premium theme wrapping", 15));
        items.add(new Service(12, "Custom Logo Design", "Minimalist logo for small business", 45));
        items.add(new Service(13, "Personalized Engraving", "Laser engrave on wood/acrylic", 30));
        items.add(new Service(14, "Event Photo Editing", "Up to 20 photos", 35));
        items.add(new Service(15, "Digital Artwork Commission", "Portrait or illustration", 50));
        items.add(new Service(16, "Custom Crochet Order", "Made-to-order crochet project", 25));
    }

    public int getLastInsertID() {
        return items.getLast().getID();
    }
}
