package dk.lyngby.dto;

import dk.lyngby.model.Plant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
@Setter
public class PlantDTO {
    private int plantId;
    private String plantType;
    private String plantName;
    private int maxHeight;
    private float price;


    public PlantDTO(Plant plant){
        this.plantId = plant.getPlantId();
        this.plantType = plant.getPlantType();
        this.plantName = plant.getPlantName();
        this.maxHeight = plant.getMaxHeight();
        this.price = plant.getPrice();
    }

/*public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

   */
}
