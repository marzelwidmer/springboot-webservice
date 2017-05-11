package ch.keepcalm.web.store.repository;

import ch.keepcalm.web.store.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by marcelwidmer on 11.05.17.
 */
public interface ProductRepository extends MongoRepository< Product, String > {

    public List<Product> findBySku(String sku);

    @Query(value = "{sku: ?0, availability : 1}")
    List<Product> findBySkuOnlyAvailablesCustom(String sku);
}