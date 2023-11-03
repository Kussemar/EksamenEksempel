package dk.lyngby.controller.impl;


import dk.lyngby.controller.IPlantController;
import dk.lyngby.dao.IPlantDAO;
import dk.lyngby.dao.impl.PlantDAOMock;
import dk.lyngby.dto.PlantDTO;
import dk.lyngby.exception.ApiException;
import dk.lyngby.exception.AuthorizationException;
import dk.lyngby.exception.Message;
import io.javalin.http.ExceptionHandler;
import io.javalin.http.Handler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PlantController implements IPlantController {
    private IPlantDAO plantDAO = PlantDAOMock.getInstance(null);

    @Override
    public Handler getAllPlants() {
        return ctx -> {
            try {
                ctx.json(plantDAO.readAll());
            } catch (Exception e) {
                ctx.status(500).json(new Message(500, "Internal server error while fetching all plants.", LocalDateTime.now()));
            }
        };
    }

    @Override
    public Handler getPlantById() {
        return ctx -> {
            try {
                int id = Integer.parseInt(ctx.pathParam("id"));

                // Assuming your DAO's read method might throw an exception if the plant is not found
                PlantDTO plant = plantDAO.read(id);
                if (plant == null) {
                    ctx.status(404).json(new Message(404, "Plant not found for the given ID.", LocalDateTime.now()));
                } else {
                    ctx.json(plant);
                }
            } catch (NumberFormatException e) {
                ctx.status(400).json(new Message(400, "Invalid ID format.",LocalDateTime.now()));
            } catch (Exception e) {
                ctx.status(500).json(new Message(500, "Internal server error.",LocalDateTime.now()));
            }
        };
    }

    @Override
    public Handler getPlantByType() {
        return ctx -> {
            try {
                String type = ctx.pathParam("type");
                ctx.json(plantDAO.getPlantByType(type));
            } catch (Exception e) {
                ctx.status(500).json(new Message(500, "Internal server error while fetching plant by type.", LocalDateTime.now()));
            }
        };
    }

    @Override
    public Handler addPlant() {
        return ctx -> {
            try {
                PlantDTO plantDTO = ctx.bodyAsClass(PlantDTO.class);
                ctx.json(plantDAO.create(plantDTO));
            } catch (Exception e) {
                ctx.status(500).json(new Message(500, "Internal server error while adding a plant.", LocalDateTime.now()));
            }
        };
    }


}