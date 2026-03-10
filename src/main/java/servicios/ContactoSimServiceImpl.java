package servicios;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

import interfaces.InterfazContactoSim;
import modelo.Celda;
import modelo.DatosSimulation;
import modelo.DatosSolicitud;
import modelo.Entidad;

@Service
public class ContactoSimServiceImpl implements InterfazContactoSim {

	private DatosSolicitud solicitudProvisional;


	private final String URL_BASE = "http://localhost:50000/grid?tok=";

	@Override
	public int solicitarSimulation(DatosSolicitud sol) {
		this.solicitudProvisional = sol;
		return new Random().nextInt(10000);
	}

	@Override
	public DatosSimulation descargarDatos(int ticket) {
		DatosSimulation datos = new DatosSimulation();
		try {
			HttpClient client = HttpClient.newHttpClient();
			// Añadimos el usuario constante que pide la práctica
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(URL_BASE + ticket + "&user=AlumnoFijo"))
					.GET()
					.build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			String[] lineas = response.body().split("\n");

			if (lineas.length > 0) {
				// El primer número es el ancho de la matriz
				datos.setAnchoMatriz(Integer.parseInt(lineas[0].trim()));

				// Procesamos el resto de las líneas (las celdas)
				for (int i = 1; i < lineas.length; i++) {
					String linea = lineas[i].trim();
					if (linea.isEmpty()) continue;

					String[] partes = linea.split(",");
					if (partes.length == 4) {
						int tiempo = Integer.parseInt(partes[0].trim());
						int posY = Integer.parseInt(partes[1].trim());
						int posX = Integer.parseInt(partes[2].trim());
						String color = partes[3].trim();

						datos.addCelda(new Celda(tiempo, posY, posX, color));
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error al conectar con la VM: " + e.getMessage());
		}
		return datos;
	}

	@Override
	public List<Entidad> getEntities() {
		List<Entidad> lista = new ArrayList<>();
		Entidad e1 = new Entidad(); e1.setId(1); e1.setName("Ordenadores");
		lista.add(e1);
		return lista;
	}

	@Override
	public boolean isValidEntityId() { return true; }
}