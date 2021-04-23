package client;
import config.ComponentMainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.Cart;
import service.ProductRepository;
import java.util.Scanner;

public class ClientSpring {
    public static void main(String[] args) {
            ApplicationContext context = new AnnotationConfigApplicationContext(ComponentMainConfig.class);
            Cart cart = context.getBean(Cart.class);
            ProductRepository pr = context.getBean(ProductRepository.class);
            System.out.println("Welcome to market");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()){
                String[] base = scanner.nextLine().split(" ");
                if (base[0].equals("add")){
                    cart.addCart(pr.getProductFromRepo(Integer.valueOf(base[1])));
                } else if (base[0].equals("sub")){
                    cart.subCart(pr.getProductFromRepo(Integer.valueOf(base[1])));
                } else if (base[0].equals("cart")) {
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

