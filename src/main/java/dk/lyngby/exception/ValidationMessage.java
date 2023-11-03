package dk.lyngby.exception;

import dk.lyngby.dto.PlantDTO;
import io.javalin.http.Handler;

import java.util.Map;

public record ValidationMessage(String message, Map<String, Object> args, Object value) {
}


