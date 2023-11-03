package dk.lyngby.dao.impl;

import dk.lyngby.dao.IPlantCenterDAO;
import dk.lyngby.model.Plant;
import dk.lyngby.model.Reseller;
import jakarta.persistence.EntityManagerFactory;


import java.util.List;

public class PlantCenterDAO implements IPlantCenterDAO {

    private static PlantCenterDAO instance;
    private static EntityManagerFactory emf;

    public static PlantCenterDAO getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PlantCenterDAO();
        }
        return instance;
    }

    @Override
    public List<Plant> getAllPlants() {
        try (var em = emf.createEntityManager()) {
            var query = em.createQuery("SELECT p FROM Plant p", Plant.class);
            return query.getResultList();
        }
    }

    @Override
    public Plant getPlantById(int id) {
        try (var em = emf.createEntityManager()) {
            return em.find(Plant.class, id);
        }
    }

    @Override
    public List<Plant> getPlantsByType(String type) {
        try (var em = emf.createEntityManager()) {
            var query = em.createQuery("SELECT p FROM Plant p WHERE p.plantType = :type", Plant.class);
            query.setParameter("type", type);
            return query.getResultList();
        }
    }

    @Override
    public Plant addPlant(Plant plant) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(plant);
            em.getTransaction().commit();
            return plant;
        }
    }

    @Override
    public Plant deletePlant(int id) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Plant plant = em.find(Plant.class, id);
            if (plant != null) {
                em.remove(plant);
                em.getTransaction().commit();
                return plant;
            }
            return null;
        }
    }

    @Override
    public Plant update(int id, Plant plant) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Plant merge = em.merge(plant);
            em.getTransaction().commit();
            return merge;
        }
    }



    @Override
    public Reseller addPlantToReseller(int resellerId, int plantId) {
        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Reseller reseller = em.find(Reseller.class, resellerId);
            Plant plant = em.find(Plant.class, plantId);

            if (reseller != null && plant != null) {
                reseller.getPlantsInStock().add(plant);
                em.merge(reseller);
                em.getTransaction().commit();
                return reseller;
            }
            em.getTransaction().commit();
            return null;
        }
    }

    @Override
    public List<Plant> getPlantsByReseller(int resellerId) {
        try (var em = emf.createEntityManager()) {
            Reseller reseller = em.find(Reseller.class, resellerId);
            if (reseller != null) {
                return reseller.getPlantsInStock();
            }
            return null;
        }
    }
}

