package dk.lyngby.routes;

import dk.lyngby.controller.IPlantController;
import dk.lyngby.controller.impl.PlantController;
import dk.lyngby.controller.impl.PlantControllerDB;
import dk.lyngby.security.RouteRoles;
import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

public class PlantRoutes {

    private final PlantControllerDB controller = new PlantControllerDB();

    protected EndpointGroup getRoutes() {
        return () -> {
            path("/plants", () -> {
                get("/", controller::readAll, RouteRoles.ANYONE);
                get("/type/{type}", controller::getPlantType, RouteRoles.ANYONE);
                get("/{id}", controller::read, RouteRoles.ANYONE);
                post("/", controller::create, RouteRoles.ANYONE);
            });
        };
    }

}
