package connector.impl;

import connector.ICatalogConnector;
import connector.base.BaseConnector;
import factory.CatalogFactory;
import model.Catalog;
import net.lvs.mongo.connector.factory.PersonFactory;
import net.lvs.mongo.connector.model.Person;
import system.mongo.core.IDynamicObject;
import system.mongo.core.connector.MongoObjectConnector;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;


public class CatalogConnector extends BaseConnector implements ICatalogConnector {

    private MongoObjectConnector getMongoObjectConnectorCatalog() {

        return getMongoObjectConnector("catalog");
    }
    @Override
    public String save(Catalog catalog) {
        CatalogFactory factory = new CatalogFactory();
        IDynamicObject iDynamicObject = factory.createObject(catalog);
        getMongoObjectConnectorCatalog().insert(iDynamicObject);
        return "catalog.page";

    }

    @Override
    public String getByNameById(String id) {
    Catalog c=  (Catalog) getMongoObjectConnectorCatalog().get(id, new CatalogFactory());
     return c.getName();
    }

    @Override
    public Catalog get(String id) {
        return (Catalog) getMongoObjectConnectorCatalog().get(id, new CatalogFactory());
    }

    @Override
    public List<Catalog> getAll() {
        return getMongoObjectConnectorCatalog().listAll(new CatalogFactory());
    }

    @Override
    public String delete(String id) {
        getMongoObjectConnectorCatalog().removeDocument(id);
        return "catalog.page";

    }

    @Override
    public String update(Catalog catalog) {
        CatalogFactory factory = new CatalogFactory();
        IDynamicObject iDynamicObject = factory.createObject(catalog);
        getMongoObjectConnectorCatalog().update(iDynamicObject);
        return "catalog.page";

    }
}
