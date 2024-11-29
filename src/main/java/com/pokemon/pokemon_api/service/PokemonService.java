package com.pokemon.pokemon_api.service;

import com.pokemon.pokemon_api.model.Pokemon;
import com.pokemon.pokemon_api.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon save(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public void deleteById(Long id) {
        pokemonRepository.deleteById(id);
    }
}
