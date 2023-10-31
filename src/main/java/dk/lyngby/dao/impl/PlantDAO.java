/*package dk.lyngby.dao.impl;


import dk.lyngby.dao.IPlantDAO;
import dk.lyngby.dto.PlantDTO;
import dk.lyngby.model.Plant;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;

public class PlantDAO implements IPlantDAO {

    private static PlantDAO instance;
    private static EntityManagerFactory emf;

    public PlantDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PlantDAO();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public List<PlantDTO> getAllPlants() {
        EntityManager em = getEntityManager();
        try {
            List<PlantDTO> plants = em.createQuery("SELECT p FROM Plant p", PlantDTO.class).getResultList();
            return plants;
        } finally {
            em.close();
        }
    }

    @Override
    public PlantDTO getPlantById(int id) {
        EntityManager em = getEntityManager();
        try {
            PlantDTO plant = em.find(PlantDTO.class, id);
            return plant;
        } finally {
            em.close();
        }
    }

    @Override
    public List<PlantDTO> getPlantByType(String type) {
        EntityManager em = getEntityManager();
        try {
            List<PlantDTO> plants = em.createQuery("SELECT p FROM Plant p WHERE p.plantType = :type", PlantDTO.class).setParameter("type", type).getResultList();
            return plants;
        } finally {
            em.close();
        }
    }

    @Override
    public PlantDTO addPlant(PlantDTO plantDTO) {
        EntityManager em = getEntityManager();
        Plant plant = new Plant();
        plant.setPlantType(plantDTO.getPlantType());
        plant.setPlantName(plantDTO.getPlantName());
        plant.setMaxHeight(plantDTO.getMaxHeight());
        plant.setPrice(plantDTO.getPrice());

        try {
            em.getTransaction().begin();
            em.persist(plant);
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        return convertToDTO(plant);
    }

    private PlantDTO convertToDTO(Plant plant){
        if(plant == null){
            return null;
        }
        PlantDTO dto = new PlantDTO();
        dto.setPlantId(plant.getPlantId());
        dto.setPlantType(plant.getPlantType());
        dto.setPlantName(plant.getPlantName());
        dto.setMaxHeight(plant.getMaxHeight());
        dto.setPrice(plant.getPrice());
        return dto;
    }
}
*/