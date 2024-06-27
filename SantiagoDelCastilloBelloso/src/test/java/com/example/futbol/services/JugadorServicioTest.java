package com.example.futbol.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.futbol.entities.Jugador;
import com.example.futbol.entities.Posicion;
import com.example.futbol.exceptions.NoJugadorException;
import com.example.futbol.repositories.JugadorRepository;


public class JugadorServicioTest {

	@Mock
	private JugadorRepository repositorio;
	
	@InjectMocks
	private JugadorServicio servicio;
	
	@BeforeEach
    public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		Jugador jugador = new Jugador();
        jugador.setId(1L);
        jugador.setNombre("Messi");
        jugador.setPosicion(Posicion.DELANTERO);
        
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador);
        when(repositorio.listaJugadores()).thenReturn(jugadores);

        when(repositorio.save(jugador)).thenReturn(jugador);
    }
	
	@Test
    public void testListaJugadores() throws NoJugadorException {
		
        List<Jugador> resultado = servicio.listaJugadores();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Messi", resultado.get(0).getNombre());
        assertEquals(Posicion.DELANTERO, resultado.get(0).getPosicion());
    }

    @Test
    public void testGuardarJugador() throws NoJugadorException {
        
        Jugador jugador = new Jugador();
        jugador.setId(1L);
        jugador.setNombre("Messi");
        jugador.setPosicion(Posicion.DELANTERO);
        
        when(repositorio.save(jugador)).thenReturn(jugador);
        
        Jugador resultado = servicio.guardarJugador(jugador);

        assertNotNull(resultado);
        assertEquals("Messi", resultado.getNombre());
        assertEquals(Posicion.DELANTERO, resultado.getPosicion());
    }
	
}
