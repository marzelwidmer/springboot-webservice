package ch.keepcalm.web.store.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by marcelwidmer on 11.05.17.
 */
@Document(collection = "products")
@Data
@Builder
public class Product {

    @Id
    private String id;
    private String sku;

    @Field(value = "material_name")
    private String materialName;

    private Double price;
    private Integer availability;

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", sku='" + sku + '\'' +
                ", materialName='" + materialName + '\'' +
                ", price=" + price +
                ", availability=" + availability +
                '}';
    }
}