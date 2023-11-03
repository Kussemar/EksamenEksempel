package dk.lyngby.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "plants")
// @NamedQueries(@NamedQuery(name = "Plant.deleteAllRows", query = "DELETE from Plant"))
@Getter
@NoArgsConstructor
@Setter

public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plant_id")
    private int plantId;

    @Column(name = "plant_type")
    private String plantType;

    @Column(name = "plant_name")
    private String plantName;

    @Column(name = "max_height")
    private int maxHeight;

    @Column(name = "price")
    private float price;


    @ManyToOne()
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;

    // Constructors, getters, setters, etc.


    public Plant(String plantType, String plantName, int maxHeight, float price) {
        this.plantType = plantType;
        this.plantName = plantName;
        this.maxHeight = maxHeight;
        this.price = price;
    }

    public Reseller getReseller() {
        return reseller;
    }

    public void setReseller(Reseller reseller) {
        this.reseller = reseller;
    }
}


