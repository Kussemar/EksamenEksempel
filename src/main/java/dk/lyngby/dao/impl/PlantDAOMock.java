package dk.lyngby.dao.impl;

import dk.lyngby.dao.IPlantDAO;
import dk.lyngby.dto.PlantDTO;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlantDAOMock implements IPlantDAO {

    private static List<PlantDTO> mockDB;
    private static PlantDAOMock instance;

    public static PlantDAOMock getInstance(EntityManagerFactory emf) {
        if (instance == null) {
            instance = new PlantDAOMock();
        }
        return instance;
    }

    private PlantDAOMock() {
        mockDB = populateMockDB();
    }

    @Override
    public PlantDTO read(Integer integer) {
        for (PlantDTO plantDTO : mockDB) {
            if (plantDTO.getPlantId() == integer) {
                return plantDTO;
            }
        }
        return null;
    }

    @Override
    public List<PlantDTO> readAll() {
        return mockDB;
    }

    @Override
    public PlantDTO create(PlantDTO plantDTO) {
        mockDB.add(plantDTO);
        return plantDTO;
    }

    @Override
    public PlantDTO update(Integer integer, PlantDTO plantDTO) {
        for (int i = 0; i < mockDB.size(); i++) {
            if (mockDB.get(i).getPlantId() == integer) {
                mockDB.set(i, plantDTO);
                return plantDTO;
            }
        }
        return null;
    }

    @Override
    public void delete(Integer integer) {
    mockDB.removeIf(plant -> plant.getPlantId() == integer);
    }

    @Override
    public boolean validatePrimaryKey(Integer integer) {
        for (PlantDTO plantDTO : mockDB) {
            if (plantDTO.getPlantId() == integer) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<PlantDTO> getPlantByType(String type) {
        List<PlantDTO> result = new ArrayList<>();
        for (PlantDTO plantDTO : mockDB) {
            if (plantDTO.getPlantType().equalsIgnoreCase(type)) {
                result.add(plantDTO);
            }
        }
        return result;
    }


    private List<PlantDTO> populateMockDB() {
        ArrayList<PlantDTO> db = new ArrayList<>();
        db.add(new PlantDTO(1, "Rose", "Albertine", 400, 199.5f));
        db.add(new PlantDTO(2, "Bush", "Aronia", 400, 169.5f));
        db.add(new PlantDTO(3, "FruitsAndBerries", "AromaApple", 350, 399.5f));
        db.add(new PlantDTO(4, "Rhododendron", "Astrid", 40, 269.5f));
        db.add(new PlantDTO(5, "Rose", "The DarkLady", 100, 199.5f));

        return db;
    }
}


