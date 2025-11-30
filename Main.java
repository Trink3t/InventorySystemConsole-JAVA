import java.util.Scanner;

public class Main {
    static Inventory inventory = new Inventory();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            
            showMainpage();
            System.out.print("Please choose a number: ");
            int num = input.nextInt();
        }
    }

    public static void showMainpage() {
        Dashboard dashboard = new Dashboard(inventory.getItems());

        System.out.println("=== INVENTORY SUMMARY ===");
        System.out.printf("%-15s %-15s %-15s\n", "Item Type", "Total Items", "Lowest Stock");
        System.out.print("--------------------------------------------\n");

        long totalProducts = dashboard.countItemByType(ItemType.PRODUCT);
        Product lowStockProduct = dashboard.getItemWithLowestStock();
        String lowStock = lowStockProduct != null ? lowStockProduct.getName() + " (" + lowStockProduct.getQuantity() + ")" : "No Product";
        System.out.printf("%-15s %-15d %-15s\n", "Products", totalProducts, lowStock);

        long totalServices = dashboard.countItemByType(ItemType.SERVICE);
        System.out.printf("%-15s %-15d %-15s\n", "Services", totalServices, "N/A");

        System.out.println("\n");
        System.out.println("Options: ");
        System.out.println("[1] - View Items");
        System.out.println("[2] - Refresh");

    }

    
}
