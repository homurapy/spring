package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import service.Cart;
import service.Product;
import service.ProductRepository;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


@Configuration
public class ComponentMainConfig {
        @Bean(name = "storage")
        public ProductRepository repository() {
            List<Product> repo = new LinkedList<>(Arrays.asList(new Product(1, "говядина в/с", 600),
                    new Product(2, "мука в/с 2 кг", 120), new Product(3, "бананы", 75),
                    new Product(4, "батон", 45), new Product(5, "яблоки Симиренко", 105)));
            return new ProductRepository(repo) ;
        }
        @Bean(name = "cart")
        public Cart cart(){
            return new Cart();
        }
}
