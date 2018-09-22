/**
 * 
 */
package br.com.avalicaocmapi.service;

import java.util.List;

import br.com.avalicaocmapi.domain.ApplicationUser;

/**
 * @author Delano Jr
 *
 */
public interface ApplicationUserService extends BaseService<ApplicationUser, Long> {

	List<ApplicationUser> consultaUsuariosAdministradores();
}
