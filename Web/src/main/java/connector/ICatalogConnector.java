package connector;



import model.Catalog;
import model.Product;

import java.util.List;

public interface ICatalogConnector {

    String save(Catalog catalog);

    String getByNameById(String id);

    Catalog get(String id);

    List<Catalog> getAll();

    String delete(String id);

    String update(Catalog catalog);


}
