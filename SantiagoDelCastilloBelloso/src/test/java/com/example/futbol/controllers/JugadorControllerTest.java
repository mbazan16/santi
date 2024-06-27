package com.example.futbol.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import com.example.futbol.entities.Jugador;
import com.example.futbol.entities.Posicion;
import com.example.futbol.exceptions.NoJugadorException;
import com.example.futbol.services.JugadorServicio;

public class JugadorControllerTest {

	@Mock
    private JugadorServicio servicio;

    @InjectMocks
    private JugadorController controller;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        
    }

    @Test
    public void testSacarJugadores() throws NoJugadorException {

        Jugador jugador = new Jugador(1L, "Messi", Posicion.DELANTERO);
        List<Jugador> jugadores = Arrays.asList(jugador);

        when(servicio.listaJugadores()).thenReturn(jugadores);

        String viewName = controller.sacarJugadores(model);

        assertEquals("jugadores", viewName);
        verify(model).addAttribute("jugadores", jugadores);
    }

    @Test
    public void testAgregarJugador() {

        String viewName = controller.agregarJugador(model);

        assertEquals("agregarJugador", viewName);
        verify(model).addAttribute(eq("jugador"), any(Jugador.class));
        verify(model).addAttribute(eq("posiciones"), anyList());
    }

    @Test
    public void testGuardarJugador() throws NoJugadorException {

        Jugador jugador = new Jugador(1L, "Messi", Posicion.DELANTERO);

        String viewName = controller.guardarJugador(jugador, model);

        assertEquals("redirect:/jugadores", viewName);
        verify(servicio).guardarJugador(jugador);
    }
}
