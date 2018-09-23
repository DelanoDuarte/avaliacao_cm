/**
 * 
 */
package br.com.avalicaocmapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.avalicaocmapi.domain.ApplicationUser;
import br.com.avalicaocmapi.service.ApplicationUserService;

/**
 * @author Delano Jr Classe de Inicializacao dos dados, para facilitar os
 *         testes.
 */
@Component
public class AppDataInitialize implements CommandLineRunner {

	@Autowired
	private ApplicationUserService applicationUserService;

	@Override
	public void run(String... args) throws Exception {

		ApplicationUser applicationUser1 = new ApplicationUser();
		applicationUser1.setName("Leandro Antonio Silva");
		applicationUser1.setLogin("leandro.silva");
		applicationUser1.setPassword("leandro123");
		applicationUser1.setEmail("leandroantoniosilva-84@leonardopereira.com");
		applicationUser1.setIsAdmin(false);

		ApplicationUser applicationUser2 = new ApplicationUser();
		applicationUser2.setName("Edson Luan Duarte");
		applicationUser2.setLogin("edson.luan");
		applicationUser2.setPassword("edson123");
		applicationUser2.setEmail("edsonluanduarte..edsonluanduarte@construtoracostanorte.com.br");
		applicationUser2.setIsAdmin(true);

		ApplicationUser applicationUser3 = new ApplicationUser();
		applicationUser3.setName("Raimundo Daniel Hugo Moraes");
		applicationUser3.setLogin("raimundo.daniel");
		applicationUser3.setPassword("raimundo123");
		applicationUser3.setEmail("raimundodanielhugomoraes_@abrangenciacorretora.com.br");
		applicationUser3.setIsAdmin(true);

		applicationUserService.save(applicationUser1);
		applicationUserService.save(applicationUser2);
		applicationUserService.save(applicationUser3);
	}

}
