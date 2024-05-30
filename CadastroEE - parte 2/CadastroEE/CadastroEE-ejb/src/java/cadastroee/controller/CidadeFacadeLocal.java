/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Cidade;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author idelm
 */
@Local
public interface CidadeFacadeLocal {

    void create(Cidade cidade);

    void edit(Cidade cidade);

    void remove(Cidade cidade);

    Cidade find(Object id);

    List<Cidade> findAll();

    List<Cidade> findRange(int[] range);

    int count();
    
}
