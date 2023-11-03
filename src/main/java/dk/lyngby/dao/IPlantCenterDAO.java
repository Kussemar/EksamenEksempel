package dk.lyngby.dao;

import dk.lyngby.dto.PlantDTO;
import dk.lyngby.model.Plant;
import dk.lyngby.model.Reseller;

import java.util.List;

public interface IPlantCenterDAO {
    List<Plant> getAllPlants();
    Plant getPlantById(int id);
    List<Plant> getPlantsByType(String type);
    Plant addPlant(Plant plant);

    Plant deletePlant(int id);
    Plant update(int id, Plant plant);

    Reseller addPlantToReseller(int resellerId, int plantId);
    List<Plant> getPlantsByReseller(int resellerId);


}
