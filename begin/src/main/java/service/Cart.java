package service;

import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;


public class Cart {
private Map<String, Integer> content;

public  Cart() {}
    public void addCart(Product product){
    if (content == null){
        content = new HashMap<>();
    }
    if (!content.containsKey(product.getTitle())){
        Integer quantity = 1;
        content.put(product.getTitle(), quantity);
    } else {
        content.put(product.getTitle(), content.get(product.getTitle())+1);
    }
    System.out.println(product.getTitle() + "  was add to the cart");
    }
    public void subCart(Product product){
        if (content.isEmpty()){
            System.out.println( "The cart is empty");
        }else if (!content.containsKey(product.getTitle())) {
            System.out.println( "Product is not in the cart");
        } else {
            content.replace(product.getTitle(), content.get(product.getTitle()) -1);
            if (content.get(product.getTitle()) == 0) {
                content.remove(product.getTitle());
            }
            System.out.println(product.getTitle() + "  was sub from the cart");
        }
    }
    public void showCart(){
        if (content == null){
            System.out.println( "The cart is empty");
        } else {
            for (Map.Entry<String, Integer> pair : content.entrySet())
            {
                String key = pair.getKey();                      //ключ
                Integer value = pair.getValue();                  //значение
                System.out.println(key + " : " + value);
            }
        }
    }


}
