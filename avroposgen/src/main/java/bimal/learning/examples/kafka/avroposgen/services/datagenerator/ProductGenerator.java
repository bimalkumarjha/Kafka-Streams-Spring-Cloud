
package bimal.learning.examples.kafka.avroposgen.services.datagenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import bimal.learning.examples.kafka.model.LineItem;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Random;

@Service
class ProductGenerator {
    private final Random random;
    private final Random qty;
    private final LineItem[] products;

    public ProductGenerator() {
        String DATAFILE = "src/main/resources/data/products.json";
        ObjectMapper mapper = new ObjectMapper();
        random = new Random();
        qty = new Random();
        try {
            products = mapper.readValue(new File(DATAFILE), LineItem[].class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int getIndex() {
        return random.nextInt(100);
    }

    private int getQuantity() {
        return qty.nextInt(2) + 1;
    }

    public LineItem getNextProduct() {
        LineItem lineItem = products[getIndex()];
        lineItem.setItemQty(getQuantity());
        lineItem.setTotalValue(lineItem.getItemPrice() * lineItem.getItemQty());
        return lineItem;
    }
}
