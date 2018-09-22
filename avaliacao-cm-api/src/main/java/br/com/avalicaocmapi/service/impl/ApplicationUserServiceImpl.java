/**
 * 
 */
package br.com.avalicaocmapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avalicaocmapi.domain.ApplicationUser;
import br.com.avalicaocmapi.repository.ApplicationUserRepository;
import br.com.avalicaocmapi.service.ApplicationUserService;

/**
 * @author Delano Jr
 *
 */
@Service
public class ApplicationUserServiceImpl implements ApplicationUserService {

	@Autowired
	private ApplicationUserRepository applicationUserRepository;

	@Override
	public ApplicationUser save(ApplicationUser user) {
		return applicationUserRepository.save(user);
	}

	@Override
	public List<ApplicationUser> saveAll(List<ApplicationUser> users) {
		return applicationUserRepository.saveAll(users);
	}

	@Override
	public List<ApplicationUser> findAll() {
		return applicationUserRepository.findAll();
	}

	@Override
	public ApplicationUser findOneById(Long id) {
		return applicationUserRepository.getOne(id);
	}

	@Override
	public void delete(Long id) {
		applicationUserRepository.deleteById(id);
	}

	@Override
	public void deleteAll(List<ApplicationUser> users) {
		applicationUserRepository.deleteAll(users);
	}

	@Override
	public List<ApplicationUser> consultaUsuariosAdministradores() {
		return applicationUserRepository.consultaUsuariosAdministradores();
	}

}
