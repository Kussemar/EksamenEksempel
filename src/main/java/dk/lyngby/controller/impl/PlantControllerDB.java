package dk.lyngby.controller.impl;


import dk.lyngby.config.HibernateConfig;
import dk.lyngby.controller.IController;
import dk.lyngby.dao.impl.PlantCenterDAO;
import dk.lyngby.dto.PlantDTO;
import dk.lyngby.exception.ApiException;
import dk.lyngby.model.Plant;

import io.javalin.http.Context;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.List;
import java.util.stream.Collectors;

public class PlantControllerDB implements IController<Plant, Integer> {

    private PlantCenterDAO dao;

    public PlantControllerDB() {
        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        this.dao = PlantCenterDAO.getInstance(emf);
    }

    @Override
    public void read(Context ctx) throws ApiException {
        // request
        int id = ctx.pathParamAsClass("id", Integer.class).check(this::validatePrimaryKey, "Not a valid id").get();
        // entity
        Plant plant = dao.getPlantById(id);
        // dto
        PlantDTO plantDTO = new PlantDTO(plant);
        // response
        ctx.res().setStatus(200);
        ctx.json(plantDTO, PlantDTO.class);
    }

    @Override
    public void readAll(Context ctx) {
        // entity
        List<Plant> plants = dao.getAllPlants();
        // dto
        List<PlantDTO> plantDtos = plants.stream().map(PlantDTO::new).collect(Collectors.toList());
        // response
        ctx.res().setStatus(200);
        ctx.json(plantDtos, PlantDTO.class);
    }

    @Override
    public void create(Context ctx) {
        // request
        Plant jsonRequest = ctx.bodyAsClass(Plant.class);
        // entity
        Plant plant = dao.addPlant(jsonRequest);
        // dto
        PlantDTO plantDTO = new PlantDTO(plant);
        // response
        ctx.res().setStatus(201);
        ctx.json(plantDTO, PlantDTO.class);
    }

    @Override
    public void update(Context ctx) {
        // request
        int id = ctx.pathParamAsClass("id", Integer.class).check(this::validatePrimaryKey, "Not a valid id").get();
        // entity
        Plant update = dao.update(id, ctx.bodyAsClass(Plant.class));
        // dto
        PlantDTO plantDTO = new PlantDTO(update);
        // response
        ctx.res().setStatus(200);
        ctx.json(plantDTO, PlantDTO.class);

    }

    @Override
    public void delete(Context ctx) throws ApiException {
        // request
        int id = ctx.pathParamAsClass("id", Integer.class).check(this::validatePrimaryKey, "Not a valid id").get();
        // entity
        Plant plant = dao.deletePlant(id);
        // dto
        PlantDTO plantDTO = new PlantDTO(plant);
        // response
        ctx.res().setStatus(200);
        ctx.json(plantDTO, PlantDTO.class);
    }

    @Override
    public boolean validatePrimaryKey(Integer integer) {
        return integer != null && integer > 0;
    }

    // lol bruger vi ikke alligevel :D
    @Override
    public Plant validateEntity(Context ctx) {
        return null;
    }

    public void getPlantType(Context ctx){
        // request
        String type = ctx.pathParam("type");
        // entity
        List<Plant> plants = dao.getPlantsByType(type);
        // dto
        List<PlantDTO> plantDtos = plants.stream().map(PlantDTO::new).collect(Collectors.toList());
        // response
        ctx.res().setStatus(200);
        ctx.json(plantDtos, PlantDTO.class);
    }


}
