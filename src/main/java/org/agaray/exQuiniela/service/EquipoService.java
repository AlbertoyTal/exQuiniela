package org.agaray.exQuiniela.service;

import java.util.Collection;

import org.agaray.exQuiniela.entities.Equipo;
import org.agaray.exQuiniela.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {
	
	@Autowired
	private EquipoRepository equipoRepository;
	
	public Collection<Equipo> findAll() {
		return equipoRepository.findAll();
	}

	public void save(String nombre) throws Exception {
		try {
			equipoRepository.save(new Equipo(nombre));
		}
		catch (Exception e) {
			throw new Exception("El equipo "+nombre+" ya existe");
		}
	}
}
