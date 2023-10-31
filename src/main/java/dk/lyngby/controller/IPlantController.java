package dk.lyngby.controller;

import io.javalin.http.Handler;
public interface IPlantController {
    Handler getAllPlants();
    Handler getPlantById();
    Handler getPlantByType();
    Handler addPlant();

}
