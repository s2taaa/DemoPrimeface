package connector;



import model.Catalog;
import model.Product;

import java.util.List;

public interface ICatalogConnector {

    void save(Catalog catalog);

    String getByNameById(String id);

    Catalog get(String id);

    List<Catalog> getAll();

    void delete(String id);

    void update(Catalog catalog);


}
