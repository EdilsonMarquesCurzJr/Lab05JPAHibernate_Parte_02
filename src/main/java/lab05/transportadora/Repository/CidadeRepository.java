package lab05.transportadora.Repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.Cidade;

import java.util.List;

public class CidadeRepository {

    private final EntityManager manager;
    private final DAO<Cidade> daoGenerico;

    public CidadeRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAO<Cidade>(manager);
    }
    public Cidade buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Cidade.class, id);
    }

    public List<Cidade> buscaTodas() {
        return this.manager.createQuery("from Cidade ", Cidade.class)
                .getResultList();
    }

    public Cidade salvaOuAtualiza(Cidade cidade) {
        return daoGenerico.salvaOuAtualiza(cidade);
    }

    public void remove(Cidade cidade) {
        daoGenerico.remove(cidade);
    }
}
