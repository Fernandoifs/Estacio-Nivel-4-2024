/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Cep;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author idelm
 */
@Local
public interface CepFacadeLocal {

    void create(Cep cep);

    void edit(Cep cep);

    void remove(Cep cep);

    Cep find(Object id);

    List<Cep> findAll();

    List<Cep> findRange(int[] range);

    int count();
    
}
