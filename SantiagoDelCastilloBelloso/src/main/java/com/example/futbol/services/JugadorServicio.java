package com.example.futbol.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.futbol.entities.Jugador;
import com.example.futbol.repositories.JugadorRepository;

@Service
public class JugadorServicio {
	Logger log = LoggerFactory.getLogger(JugadorServicio.class);
	
	@Autowired
	private JugadorRepository repositorio;
	
	public List<Jugador> listaJugadores(){
		log.info("[listaJugadores:]");
		return repositorio.listaJugadores();
	}
	
	public Jugador guardarJugador(Jugador jugador) {
		log.info("[guardarJugador:]");
		return repositorio.save(jugador);
		
	}
}
