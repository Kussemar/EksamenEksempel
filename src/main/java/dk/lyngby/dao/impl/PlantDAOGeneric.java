package dk.lyngby.dao.impl;

import dk.lyngby.dao.IDao;
import dk.lyngby.dto.PlantDTO;

import java.util.ArrayList;
import java.util.List;

public class PlantDAOGeneric implements IDao<PlantDTO, Integer> {

    // Dette er en simplificeret mockDB for demonstrative formål.
    private static List<PlantDTO> mockDB = new ArrayList<>();

    @Override
    public PlantDTO read(Integer id) {
        return mockDB.stream().filter(plant -> plant.getPlantId() == id).findFirst().orElse(null);
    }

    @Override
    public List<PlantDTO> readAll() {
        return mockDB;
    }

    @Override
    public PlantDTO create(PlantDTO plant) {
        mockDB.add(plant);
        return plant;
    }

    @Override
    public PlantDTO update(Integer id, PlantDTO plant) {
        for (int i = 0; i < mockDB.size(); i++) {
            if (mockDB.get(i).getPlantId() == id) {
                mockDB.set(i, plant);
                return plant;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        mockDB.removeIf(plant -> plant.getPlantId() == id);
    }

    @Override
    public boolean validatePrimaryKey(Integer id) {
        return mockDB.stream().anyMatch(plant -> plant.getPlantId() == id);
    }
}