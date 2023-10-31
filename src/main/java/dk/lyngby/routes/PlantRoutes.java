package dk.lyngby.routes;

import dk.lyngby.controller.IPlantController;
import dk.lyngby.controller.impl.PlantController;
import dk.lyngby.security.RouteRoles;
import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;
import static io.javalin.apibuilder.ApiBuilder.*;
public class PlantRoutes {

    private final IPlantController controller = new PlantController();

    protected EndpointGroup getRoutes(){
        return () -> {
            path("/plants", () -> {
                get("/", controller.getAllPlants(), RouteRoles.ANYONE);
                get("/type/{type}", controller.getPlantByType(), RouteRoles.ANYONE);
                get("/{id}", controller.getPlantById(), RouteRoles.ANYONE);
                post("/", controller.addPlant(), RouteRoles.ANYONE);
            });
        };
    }

}
