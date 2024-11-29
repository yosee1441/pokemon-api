package com.pokemon.pokemon_api.repository;

import com.pokemon.pokemon_api.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {}
