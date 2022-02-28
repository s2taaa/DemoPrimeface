package demo;

import connector.ICatalogConnector;
import connector.IProductConnector;
import connector.impl.CatalogConnector;
import connector.impl.ProductConnector;

public class MainTest {
    public static void main(String[] args) {
        System.setProperty("mongo.config.path", "E:\\dilam\\DemoPrimeface\\Web\\src\\main\\resources\\mongo.conf");

        IProductConnector productConnector = new ProductConnector();
        ICatalogConnector catalogConnector = new CatalogConnector();

//          CatalogData catalogData = new CatalogData();
//          System.out.print(catalogData.getCatalogs());
////        Catalog c = new Catalog("3","Nuoc");
////        catalogConnector.save(c);
//
//
//
//        ProductData productData = new ProductData();
////
//        List<Product> productList= productConnector.getAll();
//        /// tim product theo ten
//        System.out.print(productConnector.getProductByName1("banh"));




    }
}
