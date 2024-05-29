package cadastroee.controller;

import cadastroee.model.Bairro;
import java.util.List;

public interface BairroFacadeLocal {

    void create(Bairro bairro);

    void edit(Bairro bairro);

    void remove(Bairro bairro);

    Bairro find(Object id);

    List<Bairro> findAll();

    List<Bairro> findRange(int[] range);

    int count();
}
