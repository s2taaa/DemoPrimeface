package router;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "Router")
@ViewScoped
public class Router {

    public String toProduct(){
        return "product.page";
    }
    public String toCatalog(){
        return "catalog.page";
    }
    public String toCatalogForm(){
        return "catalog-form.page";
    }
    public String toProductForm(){
        return "product-form.page";
    }
}
