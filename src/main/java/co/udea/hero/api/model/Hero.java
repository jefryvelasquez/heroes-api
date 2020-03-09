package co.udea.hero.api.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "nombre")
    private String name;

    public Hero(){

    }
    public Hero(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
