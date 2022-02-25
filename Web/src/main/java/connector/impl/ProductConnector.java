package connector.impl;

import connector.IProductConnector;
import connector.base.BaseConnector;
import factory.CatalogFactory;
import factory.ProductFactory;
import model.Catalog;
import model.Product;
import net.lvs.mongo.connector.factory.PersonFactory;
import system.mongo.core.IDynamicObject;
import system.mongo.core.connector.MongoObjectConnector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;


public class ProductConnector extends BaseConnector implements IProductConnector {

    private MongoObjectConnector getMongoObjectConnectorProduct() {

        return getMongoObjectConnector("product");
    }


    @Override
    public void save(Product product) {
        ProductFactory factory = new ProductFactory();
        IDynamicObject iDynamicObject = factory.createObject(product);
        getMongoObjectConnectorProduct().insert(iDynamicObject);
    }

    @Override
    public Product get(String id) {
        return (Product) getMongoObjectConnectorProduct().get(id, new ProductFactory());
    }

    @Override
    public Product getByName(String name) {
        return (Product) getMongoObjectConnectorProduct().get(name, new ProductFactory());
    }

    @Override
    public List<Product> getAll() {
        return getMongoObjectConnectorProduct().listAll(new ProductFactory());
    }

    @Override
    public List<Product> getByCatalog(String id) {
        return null;

    }
    @Override
    public void delete(String id) {
        getMongoObjectConnectorProduct().removeDocument(id);

    }
    @Override
    public void update(Product product) {
        ProductFactory factory = new ProductFactory();
        IDynamicObject iDynamicObject = factory.createObject(product);
        getMongoObjectConnectorProduct().update(iDynamicObject);
    }

    @Override
    public List<Product> getProductByName(String name) {
        String property = "name";
        return getMongoObjectConnectorProduct().getObjectMatchProperty(property,name,new ProductFactory());
    }

    public List<Product> getProductByName1(String name) {
        List<Product> products = null;
        for (Product product : getAll()) {
            if (name.contains(product.getName()))
                products.add(product);
        }
        return products;
    }
    @Override
    public List<Product> getProductByPrice(Double price1, Double price2) {
        List<Product> products =null;
        for(Product product : getAll()){
            if(product.getPrice()>price1 && product.getPrice()<price2)
                products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getProductByCatalog(String id) {
        String property = "catalogId";
        return getMongoObjectConnectorProduct().getObjectMatchProperty(property,id,new ProductFactory());
    }
}
