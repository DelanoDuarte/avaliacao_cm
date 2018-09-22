/**
 * 
 */
package br.com.avalicaocmapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.avalicaocmapi.domain.ApplicationUser;

/**
 * @author Delano Jr
 *
 */
@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

	@Query("from ApplicationUser u where u.isAdmin = true")
	List<ApplicationUser> consultaUsuariosAdministradores();

}
