import java.util.List;

public class Dashboard {
    private List<Item> items;

    public Dashboard (List<Item> items) {
        this.items = items;
    }

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
