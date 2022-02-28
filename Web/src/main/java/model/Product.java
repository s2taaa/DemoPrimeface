package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Entity;
import javax.persistence.Id;



@ViewScoped
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private String image;
    private double price;
    private String catalogId;

}