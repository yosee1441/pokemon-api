package com.pokemon.pokemon_api;

import com.pokemon.pokemon_api.model.Pokemon;
import com.pokemon.pokemon_api.service.PokemonService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final PokemonService pokemonService;

    @Autowired
    public DataLoader(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostConstruct
    public void loadData() {
        pokemonService.save(new Pokemon("Charmander", "Fire", 8));
        pokemonService.save(new Pokemon("Bulbasaur", "Grass", 5));
        pokemonService.save(new Pokemon("Squirtle", "Water", 7));
    }
}

