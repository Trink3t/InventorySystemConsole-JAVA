
import java.io.IOException;


public class Main {
    private static final Inventory inventory = new Inventory();
    public static void main(String[] args) {
        while (true) {
            showMainpage();

            int num = InputHelper.readRequiredInt("Please choose a number: ");

            switch (num) {
                case 1 -> viewItems();
                case 2 -> System.out.println("Refreshing...\n");
                default -> System.out.println("Invalid option!");
            }
        }
    }

    public static void showMainpage() {
        clearScreen();
        Dashboard dashboard = new Dashboard(inventory.getItems());

        System.out.println("=== INVENTORY SYSTEM ===");
        System.out.printf("%-15s %-15s %-15s\n", "Item Type", "Total Items", "Lowest Stock");
        System.out.print("--------------------------------------------\n");

        long totalProducts = dashboard.countItemByType(ItemType.PRODUCT);
        Product lowStockProduct = dashboard.getItemWithLowestStock();
        String lowStock = lowStockProduct != null
                ? lowStockProduct.getName() + " (" + lowStockProduct.getQuantity() + ")"
                : "No Product";

        System.out.printf("%-15s %-15d %-15s\n", "Products", totalProducts, lowStock);

        long totalServices = dashboard.countItemByType(ItemType.SERVICE);
        System.out.printf("%-15s %-15d %-15s\n", "Services", totalServices, "N/A");

        System.out.println("\nOptions:");
        System.out.println("[1] - View Items");
        System.out.println("[2] - Refresh");
    }

    public static void viewItems() {
        clearScreen();
        while (true) {
            inventory.listItems();

            System.out.println("\nOptions:");
            System.out.println("[1] - View Item");
            System.out.println("[2] - Add Item");
            System.out.println("[3] - Refresh");
            System.out.println("[0] - Back");

            int num = InputHelper.readRequiredInt("Choose: ");

            switch (num) {
                case 1 -> viewItem();
                case 2 -> addItem();
                case 3 -> System.out.println("Refreshing...\n");
                case 0 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    public static void viewItem() {
        clearScreen();
        System.out.println("VIEW ITEM");
        while (true) {
            int item_ID = InputHelper.readRequiredInt("Enter Item ID: ");

            Item item;
            try {
                item = inventory.getItem(item_ID);
                System.out.println(item);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("\nOptions:");
            System.out.println("[1] - Update Item");
            System.out.println("[2] - Delete Item");
            System.out.println("[0] - Back");

            int num = InputHelper.readRequiredInt("Choose: ");

            switch (num) {
                case 1 -> updateItem(item);
                case 2 -> {
                    deleteItem();
                    return;
                }
                case 0 -> { return; }
                default -> System.out.println("Invalid option!");
            }
        }
    }

    public static void updateItem(Item item) {
        clearScreen();
        System.out.println("UPDATE ITEM");
        String name = InputHelper.readOptionalString("Set Name (" + item.getName() + "): ", item.getName());
        String description = InputHelper.readOptionalString("Set Description (" + item.getDescription() + "): ", item.getDescription());

        switch (item) {
            case Product p -> {
                double price = InputHelper.readOptionalDouble("Set Price (" + p.getPrice() + "): ", p.getPrice());
                int quantity = InputHelper.readOptionalInt("Set Quantity (" + p.getQuantity() + "): ", p.getQuantity());

                Product updatedProduct = new ProductBuilder(p)
                        .setName(name)
                        .setDescription(description)
                        .setPrice(price)
                        .setQuantity(quantity)
                        .build();

                inventory.updateItem(p.getID(), updatedProduct);
            }
            case Service s -> {
                double rate = InputHelper.readOptionalDouble("Set Rate (" + s.getRate() + "): ", s.getRate());

                Service updatedService = new ServiceBuilder(s)
                        .setName(name)
                        .setDescription(description)
                        .setRate(rate)
                        .build();

                inventory.updateItem(s.getID(), updatedService);
            }
            default -> {}
        }

        System.out.println("Item updated successfully!");
    }

    public static void addItem() {
        clearScreen();
        System.out.println("ADD ITEM");

        String name = InputHelper.readRequiredString("Set Name: ");
        String description = InputHelper.readRequiredString("Set Description: ");

        System.out.println("Item Type:");
        System.out.println("[1] - PRODUCT");
        System.out.println("[2] - SERVICE");

        int type = InputHelper.readRequiredInt("Set Type: ");

        try {
            switch (type) {
                case 1 -> {
                    double price = InputHelper.readRequiredDouble("Set Price: ");
                    int quantity = InputHelper.readRequiredInt("Set Quantity: ");

                    inventory.addItem(
                        new ProductBuilder(inventory.getLastInsertID() + 1)
                            .setName(name)
                            .setDescription(description)
                            .setPrice(price)
                            .setQuantity(quantity)
                            .build()
                    );
                }

                case 2 -> {
                    double rate = InputHelper.readRequiredDouble("Set Rate: ");

                    inventory.addItem(
                        new ServiceBuilder(inventory.getLastInsertID() + 1)
                            .setName(name)
                            .setDescription(description)
                            .setRate(rate)
                            .build()
                    );
                }

                default -> {
                    System.out.println("Invalid Item Type!");
                    return;
                }
            }

            System.out.println("Item Added Successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteItem() {
        clearScreen();
        System.out.println("DELETE ITEM");
        int itemID = InputHelper.readRequiredInt("Enter Item ID: ");

        try {
            inventory.removeItem(itemID);
            System.out.println("Item Successfully removed!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Unable to clear screen.");
        }
    }

}
