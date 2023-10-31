package dk.lyngby.dto;

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

    public PlantDTO(int plantId, String plantType, String plantName, int maxHeight, float price) {
        this.plantId = plantId;
        this.plantType = plantType;
        this.plantName = plantName;
        this.maxHeight = maxHeight;
        this.price = price;
    }
/*public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

   */
}
