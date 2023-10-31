package dk.lyngby.controller.impl;


import dk.lyngby.controller.IPlantController;
import dk.lyngby.dao.IPlantDAO;
import dk.lyngby.dao.impl.PlantDAOMock;
import dk.lyngby.dto.PlantDTO;
import io.javalin.http.Handler;

public class PlantController implements IPlantController {
    private IPlantDAO plantDAO = PlantDAOMock.getInstance(null);  // Updated this line to use the static getInstance method

    @Override
    public Handler getAllPlants() {
        return ctx -> {
            ctx.json(plantDAO.readAll());  // Use readAll instead of getAllPlants
        };
    }

    @Override
    public Handler getPlantById() {
        return ctx -> {
            int id = Integer.parseInt(ctx.pathParam("id"));
            ctx.json(plantDAO.read(id));  // Use read instead of getPlantById
        };
    }

    @Override
    public Handler getPlantByType() {
        return ctx -> {
            String type = ctx.pathParam("type");
            ctx.json(plantDAO.getPlantByType(type));  // This one is correct
        };
    }

    @Override
    public Handler addPlant() {
        return ctx -> {
            PlantDTO plantDTO = ctx.bodyAsClass(PlantDTO.class);
            ctx.json(plantDAO.create(plantDTO));  // Use create instead of addPlant
        };
    }
}
