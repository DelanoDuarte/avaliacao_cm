/**
 * 
 */
package br.com.avalicaocmapi.domain;

import java.io.Serializable;

/**
 * @author Delano Jr
 *
 */
public class Mensagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
