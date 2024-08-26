package lab05.transportadora.Repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.CategoriaFrete;

import java.util.List;

public class CategoriaFreteRepository {
    private final EntityManager manager;
    private final DAO<CategoriaFrete> daoGenerico;

    public CategoriaFreteRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAO<CategoriaFrete>(manager);
    }
    public CategoriaFrete buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(CategoriaFrete.class, id);
    }

    public List<CategoriaFrete> buscaTodas() {
        return this.manager.createQuery("from CategoriaFrete ", CategoriaFrete.class)
                .getResultList();
    }

    public CategoriaFrete salvaOuAtualiza(CategoriaFrete categoriaFrete) {
        return daoGenerico.salvaOuAtualiza(categoriaFrete);
    }

    public void remove(CategoriaFrete categoriaFrete) {
        daoGenerico.remove(categoriaFrete);
    }
}
