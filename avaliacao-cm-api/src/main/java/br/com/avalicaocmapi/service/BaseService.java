/**
 * 
 */
package br.com.avalicaocmapi.service;

import java.util.List;

/**
 * @author Delano Jr
 *
 */
public interface BaseService<T, ID> {

	public T save(T t);

	public List<T> saveAll(List<T> t);

	public List<T> findAll();

	public T findOneById(ID id);

	public void delete(ID id);

	public void deleteAll(List<T> t);
}
