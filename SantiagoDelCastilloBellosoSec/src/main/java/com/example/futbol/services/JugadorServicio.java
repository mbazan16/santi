package com.example.futbol.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.futbol.entities.Jugador;
import com.example.futbol.exceptions.NoJugadorException;
import com.example.futbol.repositories.JugadorRepository;

@Service
public class JugadorServicio {
	Logger log = LoggerFactory.getLogger(JugadorServicio.class);
	
	@Autowired
	private JugadorRepository repositorio;
	
	public List<Jugador> listaJugadores() throws NoJugadorException{
		log.info("[listaJugadores:]");
		try {
	        log.info("[listaJugadores:]");
	        return repositorio.listaJugadores();
	    } catch (Exception e) {
	        log.error("Error al obtener la lista de jugadores", e);
	        throw new NoJugadorException("Error al obtener la lista de jugadores: " + e.getMessage());
	    }
	}
	
	public Jugador guardarJugador(Jugador jugador) throws NoJugadorException {
		log.info("[guardarJugador:]");
		if (jugador == null || jugador.getNombre() == null || jugador.getNombre().isEmpty()) {
            throw new NoJugadorException("El jugador no se ha podido guardar");
        }
		return repositorio.save(jugador);
		
	}
}
