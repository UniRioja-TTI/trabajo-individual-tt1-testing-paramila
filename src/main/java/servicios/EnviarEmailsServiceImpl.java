package servicios;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import interfaces.InterfazEnviarEmails;
import modelo.Destinatario;

@Service
public class EnviarEmailsServiceImpl implements InterfazEnviarEmails {

	private final Logger logger;

	// Inyectamos el logger en el constructor
	public EnviarEmailsServiceImpl(Logger logger) {
		this.logger = logger;
	}

	@Override
	public boolean enviarEmail(Destinatario dest, String email) {
		// Loggeamos el correo en lugar de enviarlo de verdad
		logger.info("Simulando envío de correo: " + email);
		return true;
	}
}