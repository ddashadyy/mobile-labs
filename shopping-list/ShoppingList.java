import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class ShoppingList {
    public static void main(String[] args) {
        Map<String, Map<String, Integer>> shopDataBase = new TreeMap<>();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] row = sc.nextLine().split(" ");

            String customer = row[0];
            String product = row[1];
            int amount = Integer.parseInt(row[2]);

            shopDataBase.putIfAbsent(customer, new TreeMap<>());
            shopDataBase.get(customer).put(product, shopDataBase.get(customer).getOrDefault(product, 0) + amount);
        }

        sc.close();

        shopDataBase.forEach((customer, products) -> {

            System.out.println(customer + ":");

            products.forEach((product, amount) -> {
                System.out.println(" " + product + " " + amount);
            });
        });
    }
}
