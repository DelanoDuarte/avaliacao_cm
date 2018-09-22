/**
 * 
 */
package br.com.avalicaocmapi.resource;

import java.io.Serializable;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.avalicaocmapi.domain.Mensagem;

/**
 * @author Delano Jr
 *
 */
@RestController
@RequestMapping(value = "/email")
public class EmailResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@PostMapping
	protected ResponseEntity<?> sendMessage(@RequestBody Mensagem mensagem) {

		try {
			rabbitTemplate.convertAndSend("avaliacaocm_mensageria.msg", mensagem.getTexto());
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
