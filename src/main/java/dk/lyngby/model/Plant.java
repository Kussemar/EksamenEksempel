/*package dk.lyngby.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name = "plants")
@NamedQueries(@NamedQuery(name = "Plant.deleteAllRows", query = "DELETE from Plant"))
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
    private int price;
}


 */