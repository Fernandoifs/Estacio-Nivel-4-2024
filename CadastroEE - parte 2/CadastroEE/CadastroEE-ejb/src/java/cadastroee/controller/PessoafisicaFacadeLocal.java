/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Pessoafisica;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author idelm
 */
@Local
public interface PessoafisicaFacadeLocal {

    void create(Pessoafisica pessoafisica);

    void edit(Pessoafisica pessoafisica);

    void remove(Pessoafisica pessoafisica);

    Pessoafisica find(Object id);

    List<Pessoafisica> findAll();

    List<Pessoafisica> findRange(int[] range);

    int count();
    
}
