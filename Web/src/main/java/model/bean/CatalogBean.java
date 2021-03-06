package model.bean;

import connector.impl.CatalogConnector;
import model.Catalog;
import model.Product;
import util.DataFile;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.File;
import java.io.IOException;
import java.util.List;

@ManagedBean(name = "Catalog")
@SessionScoped
public class CatalogBean  {

    private List<Catalog> catalogs;
    private Catalog catalogSelected;
    private String id;
    private String name;

    private  CatalogConnector catalogConnector;

    @PostConstruct
    public void init(){
        catalogConnector = new CatalogConnector();
        catalogs = catalogConnector.getAll();
    }


    public void add(){
        Catalog model = new Catalog();
        model.setName(name);
        catalogConnector.save(model);

    }

    public void update(){

        catalogConnector.update(catalogSelected);

    }
    public void delete(String id){
        catalogConnector.delete(id);
    }



    public Catalog getCatalogSelected() {
        return catalogSelected;
    }

    public void setCatalogSelected(Catalog catalogSelected) {
        this.catalogSelected = catalogSelected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Catalog> getCatalogs() {
        catalogs = catalogConnector.getAll();
        return catalogs;
    }

    public void setCatalogs(List<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public CatalogConnector getCatalogConnector() {
        return catalogConnector;
    }

    public void setCatalogConnector(CatalogConnector catalogConnector) {
        this.catalogConnector = catalogConnector;
    }
}
