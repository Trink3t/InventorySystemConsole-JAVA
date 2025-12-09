import java.util.List;

public class Dashboard {
    private final List<Item> items;

    public Dashboard (List<Item> items) {
        this.items = items;
    }

    /**
     * Returns the number of items in the inventory of the given type.
     * 
     * @param type the type of item to count
     * @return the number of items of the given type in the inventory
     */
    public long countItemByType(ItemType type) {
        long count = 0;

        switch (type) {
            case PRODUCT -> {
                for (Item item : items) {
                    if (item instanceof Product) count++;
                }
            }
            case SERVICE -> {
                for (Item item : items) {
                    if (item instanceof Service) count++;
                }
            }
        }

        return count;
    }

    /**
     * Returns the product with the lowest quantity in the inventory.
     * 
     * @return the product with the lowest quantity in the inventory, or null if no products are found
     */
    public Product getItemWithLowestStock() {
        Product lowest = null;

        for (Item item : items) {
            if (item instanceof Product product) {
                if (lowest == null || product.getQuantity() < lowest.getQuantity()) {
                    lowest = product;
                }
            }
        }

        return lowest;
    }

}
