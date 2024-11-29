package com.pokemon.pokemon_api.dto;

import jakarta.validation.constraints.*;

public class PokemonDto {
    @NotBlank(message = "El nombre no puede estar vacío")
    private String name;

    @NotBlank(message = "El tipo no puede estar vacío")
    private String type;

    @NotNull(message = "El nivel no puede estar nulo")
    @Min(value = 1, message = "El nivel debe ser al menos 1")
    @Max(value = 100, message = "El nivel no puede ser mayor a 100")
    private Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}

