package service;

import service.Product;

import java.util.List;

public class ProductRepository {
    private List<Product> repo;

    public ProductRepository(List<Product> repo) {
        this.repo = repo;
    }
    public void setRepo(List <Product> repo) {
        this.repo = repo;
    }

    public List <Product> getRepo() {
        return repo;
    }
    public Product getProductFromRepo(Integer id){
        for (Product product : repo) {
            if (product.getId() == id){
                return product;
            }
        }
        System.out.println("Product with id " + id + " is not listed");
            return null;
    }
    public void showRepo(){
        for (Product product : repo) {
            product.show();
        }
    }

}
