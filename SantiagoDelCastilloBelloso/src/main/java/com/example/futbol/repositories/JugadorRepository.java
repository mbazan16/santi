package com.example.futbol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.futbol.entities.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador,Long>{

	List<Jugador> listaJugadores();

}
