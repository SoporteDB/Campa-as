package com.dba.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.dba.demo.model.Promocion;
import com.dba.demo.service.PromocionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/eficaciaChatBot")
@RequiredArgsConstructor
public class PromocionController {
	
	private final PromocionService promocionService;

	@PostMapping("/promocion")
	public ResponseEntity<Promocion>guardar(@RequestBody Promocion promocion){
		HttpStatus status=null;
		try {
			promocionService.add(promocion);
			status=HttpStatus.CREATED;
		}catch (Exception e) {
			status=HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return ResponseEntity.status(status).body(promocion);
	}
	
	
	@GetMapping("/promocion")
	public List<Promocion> findAll(){
		return promocionService.findAll();
	}
	
	@GetMapping("/promocion/{id}")
	public Promocion findById(@PathVariable String id) {
		return promocionService.findById(id).get();
	}
	
	@DeleteMapping("/promocion/{id}")
	public void deleteById(@PathVariable String id) {
		promocionService.deleteById(id);
	}
	
	/*
	@PutMapping("/campañas")
	public void update(@RequestBody Campaña camapaña) {
		camapañaService.saveg(camapaña);
	}
	*/
}
