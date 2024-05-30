package cadastroee.controller;

import cadastroee.model.Bairro;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class BairroFacade extends AbstractFacade<Bairro> implements BairroFacadeLocal {

    @PersistenceContext(unitName = "CadastroEE-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BairroFacade() {
        super(Bairro.class);
    }
    
}
