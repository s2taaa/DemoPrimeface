package connector;

import model.Product;

import java.util.List;

public interface IProductConnector {
    void save(Product product);

    Product get(String id);

    Product getByName(String name);

    List<Product> getAll();

    List<Product> getProductByName(String name);
   List<Product> getProductByName1(String name);

    List<Product> getProductByPrice(Double price1,Double price2);

    List<Product> getProductByCatalog(String id);

    List<Product> getByCatalog(String id);

    void delete(String id);

    void update(Product product);
}
