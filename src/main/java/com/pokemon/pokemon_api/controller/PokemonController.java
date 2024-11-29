package com.pokemon.pokemon_api.controller;

import com.pokemon.pokemon_api.dto.PokemonDto;
import com.pokemon.pokemon_api.model.Pokemon;
import com.pokemon.pokemon_api.service.PokemonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {
    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> findAll() {
        return pokemonService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> findById(@PathVariable Long id) {
        return pokemonService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pokemon> save(@Valid @RequestBody PokemonDto dto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(dto.getName());
        pokemon.setType(dto.getType());
        pokemon.setLevel(dto.getLevel());

        Pokemon createdPokemon = pokemonService.save(pokemon);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPokemon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> update(@PathVariable Long id, @RequestBody PokemonDto dto) {
        Optional<Pokemon> existingPokemon = pokemonService.findById(id);

        if (existingPokemon.isPresent()) {
            Pokemon pokemon = existingPokemon.get();
            pokemon.setName(dto.getName());
            pokemon.setType(dto.getType());
            pokemon.setLevel(dto.getLevel());
            Pokemon savedPokemon = pokemonService.save(pokemon);
            return ResponseEntity.ok(savedPokemon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (pokemonService.findById(id).isPresent()) {
            pokemonService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
