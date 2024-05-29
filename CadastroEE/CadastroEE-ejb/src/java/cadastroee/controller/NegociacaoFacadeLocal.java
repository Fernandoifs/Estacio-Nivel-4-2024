/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cadastroee.controller;

import cadastroee.model.Negociacao;
import java.util.List;
import jakarta.ejb.Local;

/**
 *
 * @author idelm
 */
@Local
public interface NegociacaoFacadeLocal {

    void create(Negociacao negociacao);

    void edit(Negociacao negociacao);

    void remove(Negociacao negociacao);

    Negociacao find(Object id);

    List<Negociacao> findAll();

    List<Negociacao> findRange(int[] range);

    int count();
    
}
