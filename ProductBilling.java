import java.util.Scanner;

class Product {
    int id;
    String name;
    double price;
    int quantity;
}

public class ProductBilling {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] products = new Product[5];

        // Input details of 5 products
        for (int i = 0; i < 5; i++) {

            products[i] = new Product();

            System.out.println("Product " + (i + 1) + ":");

            System.out.print("ID: ");
            products[i].id = sc.nextInt();

            System.out.print("Name: ");
            products[i].name = sc.next();

            System.out.print("Price: ");
            products[i].price = sc.nextDouble();

            System.out.print("Quantity: ");
            products[i].quantity = sc.nextInt();

            System.out.println();
        }

        // Calculate and display bill
        for (int i = 0; i < 5; i++) {

            double totalPrice;
            double discount;
            double finalPrice;

            totalPrice = products[i].price * products[i].quantity;

            if (totalPrice >= 5000) {
                discount = totalPrice * 10 / 100;
            } else {
                discount = totalPrice * 5 / 100;
            }

            finalPrice = totalPrice - discount;

            System.out.println("Product ID: " + products[i].id);
            System.out.println("Name: " + products[i].name);
            System.out.println("Total Price: ₹" + totalPrice);
            System.out.println("Discount: ₹" + discount);
            System.out.println("Final Price: ₹" + finalPrice);
            System.out.println("-------------------------");
        }

        sc.close();
    }
}