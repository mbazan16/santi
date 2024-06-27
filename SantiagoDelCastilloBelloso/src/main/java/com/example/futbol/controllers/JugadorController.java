package com.example.futbol.controllers;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.futbol.entities.Jugador;
import com.example.futbol.entities.Posicion;
import com.example.futbol.services.JugadorServicio;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {
	Logger log = LoggerFactory.getLogger(JugadorController.class);
	
	
	@Autowired
	private JugadorServicio servicio;
	
	@GetMapping
	public String sacarJugadores(Model model) {
		log.info("[sacarJugadores:]");
		model.addAttribute("jugadores", servicio.listaJugadores());
		
		return "jugadores";
	}
	
	
	@GetMapping("/agregarJugador")
	public String agregarJugador(Model model) {
		log.info("[agregarJugador:]");
		model.addAttribute("jugador", new Jugador());
        model.addAttribute("posicion", Arrays.asList(Posicion.values()));
		
		return "agregarJugador";
	}
	
	
	@PostMapping
    public String guardarJugador(@ModelAttribute Jugador jugador) {
        servicio.guardarJugador(jugador);
        return "redirect:/jugadores";
    }
	
}
