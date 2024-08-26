package lab05.transportadora.Repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.Frete;

import java.util.List;

public class FreteRepository {
    private final EntityManager manager;
    private DAO<Frete> daoGenerico;

    public FreteRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAO<Frete>(manager);
    }

    public Frete buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Frete.class, id);
    }

    public List<Frete> buscaTodos() {
        return this.manager.createQuery("from Frete ", Frete.class)
                .getResultList();
    }

    public Frete salvaOuAtualiza(Frete frete) {
        return daoGenerico.salvaOuAtualiza(frete);
    }

    public void remove(Frete frete) {
        daoGenerico.remove(frete);
    }
}
