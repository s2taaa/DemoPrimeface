package model.bean;

import connector.impl.CatalogConnector;
import connector.impl.ProductConnector;
import model.Catalog;
import model.Product;
import org.primefaces.model.file.UploadedFile;
import util.DataFile;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "Product")
@SessionScoped
public class ProductBean {
    private List<Product> products;
    private String productId;
    private String productName;
    private UploadedFile productImage;
    private double productPrice;
    private String productCatalogId;
    private Product productSelected;
    private final static String IMAGE_STORE="E:\\dilam\\DemoPrimeface\\Web\\web\\images";

    private Map<String, Catalog> catalogMap;
    private String nameProductSearch = null;
    private String nameCatalogSearch = null;
    private Double minPrice = 0.0;
    private Double maxPrice = 0.0;


    private ProductConnector productConnector;
    private CatalogConnector catalogConnector;
//funtion

    @PostConstruct
    public void init(){
        productConnector = new ProductConnector();
        catalogConnector = new CatalogConnector();

        catalogMap = new HashMap<>();
        List<Catalog> catalogList = catalogConnector.getAll();
        for (Catalog catalog: catalogList) {
            catalogMap.put(catalog.getId(),catalog);
        }

    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProducts() {
        products = productConnector.getAll();
        return products;
    }
    public void add(){
            Product model = new Product();
            model.setName(productName);
            model.setPrice(productPrice);
            model.setCatalogId(productCatalogId);
            File file = null;
            String imageName = productImage.getFileName();
            file = new File(IMAGE_STORE,imageName);
            try {
                DataFile.saveToDickImage(file,productImage.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            model.setImage(file.getName());
            productConnector.save(model);

    }

    public void update(){
            File file = null;
            String imageName = productImage.getFileName();
            file = new File(IMAGE_STORE,imageName);
            try {
                DataFile.saveToDickImage(file,productImage.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            productSelected.setImage(file.getName());
            productConnector.update(productSelected);

    }
    public void delete(String id){
            productConnector.delete(id);
    }


    public void searchProduct(){
        List<Product> productSearchByNameList = null;
        if(nameProductSearch != null ) {
            productSearchByNameList = productConnector.getProductByName(nameProductSearch);
        }
        if(productSearchByNameList != null) {
            products = productSearchByNameList;
        }
        for (Product product: products) {
            if(!product.getCatalogId().contains(nameCatalogSearch) || (product.getPrice()>minPrice && product.getPrice()<maxPrice) ){
                products.remove(product);
            }

        }
    }
//getter setter
    public ProductConnector getProductConnector() {
        return productConnector;
    }

    public void setProductConnector(ProductConnector productConnector) {
        this.productConnector = productConnector;
    }


    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public UploadedFile getProductImage() {
        return productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductCatalogId() {
        return productCatalogId;
    }

    public Product getProductSelected() {
        return productSelected;
    }

    public CatalogConnector getCatalogConnector() {
        return catalogConnector;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductImage(UploadedFile productImage) {
        this.productImage = productImage;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductCatalogId(String productCatalogId) {
        this.productCatalogId = productCatalogId;
    }

    public void setProductSelected(Product productSelected) {
        this.productSelected = productSelected;
    }

    public void setCatalogConnector(CatalogConnector catalogConnector) {
        this.catalogConnector = catalogConnector;
    }

    public String getNameProductSearch() {
        return nameProductSearch;
    }

    public void setNameProductSearch(String nameProductSearch) {
        this.nameProductSearch = nameProductSearch;
    }

    public String getNameCatalogSearch() {
        return nameCatalogSearch;
    }

    public void setNameCatalogSearch(String nameCatalogSearch) {
        this.nameCatalogSearch = nameCatalogSearch;
    }

    public Map<String, Catalog> getCatalogMap() {return catalogMap;}

    public void setCatalogMap(Map<String, Catalog> catalogMap) {
        this.catalogMap = catalogMap;
    }


}
