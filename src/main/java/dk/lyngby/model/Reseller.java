package dk.lyngby.model;

import dk.lyngby.model.Plant;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resellers")
@NoArgsConstructor
public class Reseller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reseller_id")

    private int id;

    @Column(name = "reseller_name")
    private String name;
    @Column(name = "reseller_address")
    private String address;
    @Column(name = "reseller_phone")
    private int phone;

    @OneToMany(mappedBy = "reseller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Plant> plantsInStock = new ArrayList<>();

    // Constructors, getters, setters, etc.

    public Reseller(String name, String address, int phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }


    // getters and setters for each property...

    public List<Plant> getPlantsInStock() {
        return plantsInStock;
    }

    public void setPlantsInStock(List<Plant> plantsInStock) {
        this.plantsInStock = plantsInStock;
    }

    public void addPlant(Plant plant) {
        plantsInStock.add(plant);
      //  plant.setReseller(this);
    }
}

