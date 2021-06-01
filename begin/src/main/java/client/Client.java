package client;

import service.Cart;
import service.Product;
import service.ProductRepository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        List<Product> repo = new LinkedList<>(Arrays.asList(new Product(1, "говядина в/с", 600),
        new Product(2, "мука в/с 2 кг", 120), new Product(3, "бананы", 75),
        new Product(4, "батон", 45), new Product(5, "яблоки Симиренко", 105)));
        ProductRepository pr = new ProductRepository(repo);
        Cart cart = new Cart();
        System.out.println("Welcome to market");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (scanner.hasNext()){
            String[] base = scanner.nextLine().split(" ");
            if (base[0].equals("add")){
                cart.addCart(pr.getProductFromRepo(Integer.valueOf(base[1])));
            } else if (base[0].equals("sub")){
                cart.subCart(pr.getProductFromRepo(Integer.valueOf(base[1])));
            } else if (base[0].equals("cart") && base[1].equals("cart")) {
                cart.showCart();
            } else if (base[0].equals("show")) {
                System.out.println("List of product");
                pr.showRepo();
            } else if (base[0].equals("person")) {
                pr.getProductFromRepo(Integer.valueOf(base[1])).show();
            }else if (base[0].equals("new")) {
                cart = new Cart();
                System.out.println("Great new cart");
            } else {
                System.out.println("Wrong command");}
        }
    }
}
