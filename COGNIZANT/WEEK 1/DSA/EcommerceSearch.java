import java.util.Arrays;
import java.util.Scanner;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}

public class EcommerceSearch {

    public static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {//check the name and userinput
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = products[mid].productName.compareToIgnoreCase(name);//compares it with the user's input name without caring about uppercase/lowercase.
            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Book", "Education"),
            new Product(104, "Pen", "Stationery"),
            new Product(105, "Shoes", "Fashion")
        };

        Arrays.sort(products, (a, b) -> a.productName.compareToIgnoreCase(b.productName));//sort for binary search

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine();

        System.out.println("\n-- Linear Search --");
        Product result1 = linearSearch(products, searchName);
        if (result1 != null) {
            System.out.println("Found: " + result1.productName + " in " + result1.category);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("\n-- Binary Search --");
        Product result2 = binarySearch(products, searchName);
        if (result2 != null) {
            System.out.println("Found: " + result2.productName + " in " + result2.category);
        } else {
            System.out.println("Product not found.");
        }
    }
}
