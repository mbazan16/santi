package com.example.futbol.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.futbol.entities.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador,Long>{

	@Query("SELECT j FROM Jugador j")
	List<Jugador> listaJugadores();

}
