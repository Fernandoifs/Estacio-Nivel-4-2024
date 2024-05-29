/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Logradouro;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author idelm
 */
@Local
public interface LogradouroFacadeLocal {

    void create(Logradouro logradouro);

    void edit(Logradouro logradouro);

    void remove(Logradouro logradouro);

    Logradouro find(Object id);

    List<Logradouro> findAll();

    List<Logradouro> findRange(int[] range);

    int count();
    
}
