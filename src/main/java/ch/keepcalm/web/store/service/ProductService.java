package ch.keepcalm.web.store.service;

import ch.keepcalm.web.store.model.Product;
import ch.keepcalm.web.store.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marcelwidmer on 11.05.17.
 */
@Service
public class ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getSku(String sku) {
        return repository.findBySku(sku);
    }

    public List<Product> getAvailableSkuCustom(String sku) {
        return repository.findBySkuOnlyAvailablesCustom(sku);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }
}