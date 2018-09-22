/**
 * 
 */
package br.com.avalicaocmapi.resource;

import java.io.Serializable;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avalicaocmapi.domain.ApplicationUser;
import br.com.avalicaocmapi.service.ApplicationUserService;
import io.swagger.annotations.Api;

/**
 * @author Delano Jr
 *
 */
@Api(value = "User Resource")
@RestController
@RequestMapping(value = "/user")
public class ApplicationUserResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ApplicationUserService applicationUserService;

	@GetMapping
	protected ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.ok(applicationUserService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON)
	protected ResponseEntity<?> save(@RequestBody ApplicationUser applicationUser) {
		try {
			return ResponseEntity.ok(applicationUserService.save(applicationUser));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/{userId}")
	protected ResponseEntity<?> findOne(@PathVariable("userId") Long userId) {
		try {
			return ResponseEntity.ok(applicationUserService.findOneById(userId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping
	protected ResponseEntity<?> update(@PathVariable("userId") Long userId,
			@RequestBody ApplicationUser applicationUser) {
		try {
			return ResponseEntity.ok(applicationUserService.save(applicationUser));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping
	protected ResponseEntity<?> detele(@PathVariable("userId") Long userId) {
		try {
			applicationUserService.delete(userId);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "/admin")
	protected ResponseEntity<?> findUsuarioAdministradores() {
		try {
			return ResponseEntity.ok(applicationUserService.consultaUsuariosAdministradores());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
