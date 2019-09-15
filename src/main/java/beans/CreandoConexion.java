package beans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.example.core.model.Conexion;

@Component
public class CreandoConexion {

	@Bean(name = "beanConexion")
	public Conexion getConexion() {
		Conexion conexion = new Conexion();
		conexion.setBd("gaaaaa");
		conexion.setBd("MySql");
		conexion.setUrl("localhost");
		return conexion;
	}
}
