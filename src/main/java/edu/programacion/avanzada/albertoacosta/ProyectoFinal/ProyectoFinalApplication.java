package edu.programacion.avanzada.albertoacosta.ProyectoFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoFinalApplication {

	/*El programa sigue conteniendo errores a la hora de compilar:

	1-CQRSConfiguration (se encuentra en configuration)
	2-En resources aparece gris en vez de naranja

	No sé por qué sucede, están escritos de la misma manera que en los videos
	*/
	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

}
