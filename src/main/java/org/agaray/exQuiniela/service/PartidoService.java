package org.agaray.exQuiniela.service;

import java.time.LocalDate;
import java.util.Collection;

import org.agaray.exQuiniela.entities.Partido;
import org.agaray.exQuiniela.repository.EquipoRepository;
import org.agaray.exQuiniela.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartidoService {
	
	@Autowired
	private PartidoRepository partidoRepository;
	
	@Autowired
	private EquipoRepository equipoRepository;

	public Collection<Partido> findAll() {
		return partidoRepository.findAll();
	}

	public void save(int nJornada, LocalDate fecha, int gl, int gv, Long idLocal, Long idVisitante) {
		
		Partido partido = new Partido();
		
		partido.setnJornada(nJornada);
		partido.setFecha(fecha);
		partido.setGl(gl);
		partido.setGv(gv);
		partido.setLocal(equipoRepository.getById(idLocal));
		partido.setVisitante(equipoRepository.getById(idVisitante));
		
		partidoRepository.save(partido);
	}

	public Collection<Partido> findByFecha(LocalDate fecha) {
		return partidoRepository.findByFecha(fecha);
	}

}
