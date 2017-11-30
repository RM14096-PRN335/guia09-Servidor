/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.prn335_2017.datos.acceso;

import java.util.List;

/**
 *
 * @author ed
 * @param <T>
 */
public interface InterfaceFacade<T> {
    
    boolean create(T rol);

    boolean edit(T rol);

    boolean remove(T rol);

    T find(Object id);

    List<T> findAll();

    List<T> findRange(int first, int pageSize);

    int count();
}
