package model;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@ManagedBean(name = "Catalog")
public class Catalog {
    @Id
    private String id;
    private String name;

}
