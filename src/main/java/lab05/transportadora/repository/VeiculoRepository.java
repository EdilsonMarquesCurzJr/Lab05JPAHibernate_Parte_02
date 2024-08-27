package lab05.transportadora.repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.Veiculo;

import java.util.List;

public class VeiculoRepository {
    private final EntityManager manager;
    private DAO<Veiculo> daoGenerico;

    public VeiculoRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAO<Veiculo>(manager);
    }

    public Veiculo buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Veiculo.class, id);
    }

    public List<Veiculo> buscaTodos() {
        return this.manager.createQuery("from Veiculo ", Veiculo.class)
                .getResultList();
    }

    public Veiculo salvaOuAtualiza(Veiculo veiculo) {
        return daoGenerico.salvaOuAtualiza(veiculo);
    }

    public void remove(Veiculo veiculo) {
        daoGenerico.remove(veiculo);
    }
}
