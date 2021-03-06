package pl.javastart.mvc.intro;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productsTab;

    public ProductRepository() {
        productsTab = new ArrayList<>();

        productsTab.add(new Product ("Mleko", 2.5, ProductCategory.CAT1.getDescription()));
        productsTab.add(new Product ("Odkurzacz", 250.5, ProductCategory.CAT2.getDescription()));
        productsTab.add(new Product ("Samochod", 140000.00, ProductCategory.CAT3.getDescription()));
    }

    public List<Product> getProducts() {
        return productsTab;
    }

    public void addProduct(Product product) {
        productsTab.add(product);
    }
}
