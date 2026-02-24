package servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import interfaces.InterfazContactoSim;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;

@Service
public class ContactoSimServiceImpl implements InterfazContactoSim {

	// Variable para almacenar provisionalmente los datos como pide el guion
	private DatosSolicitud solicitudProvisional; 

	@Override
	public int solicitarSimulation(DatosSolicitud sol) {
		this.solicitudProvisional = sol; // Almacenamos la solicitud provisionalmente
		// Devolvemos un token aleatorio entre 0 y 9999
		return new Random().nextInt(10000); 
	}

	@Override
	public DatosSimulation descargarDatos(int ticket) {
		return null; // De momento no se usa
	}

	@Override
	public List<Entidad> getEntities() {
		// Inventamos una lista de nombres para las entidades
		List<Entidad> lista = new ArrayList<>();
		
		Entidad e1 = new Entidad();
		e1.setId(1);
		e1.setName("Ordenadores");
		
		Entidad e2 = new Entidad();
		e2.setId(2);
		e2.setName("Servidores");
		
		lista.add(e1);
		lista.add(e2);
		
		return lista;
	}

	@Override
	public boolean isValidEntityId() {
		return true; // Suponemos que siempre es válido para que el formulario funcione
	}
}
