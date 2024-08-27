package lab05.transportadora.repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.TipoVeiculo;

import java.util.List;

public class TipoVeiculoRepository {
    private final EntityManager manager;
    private DAO<TipoVeiculo> daoGenerico;

    public TipoVeiculoRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAO<TipoVeiculo>(manager);
    }

    public TipoVeiculo buscaPor(Integer id) {
        return daoGenerico.buscaPorId(TipoVeiculo.class, id);
    }

    public List<TipoVeiculo> buscaTodos() {
        return this.manager.createQuery("from Dependente ", TipoVeiculo.class)
                .getResultList();
    }

    public TipoVeiculo salvaOuAtualiza(TipoVeiculo tipoVeiculo) {
        return daoGenerico.salvaOuAtualiza(tipoVeiculo);
    }

    public void remove(TipoVeiculo tipoVeiculo) {
        daoGenerico.remove(tipoVeiculo);
    }
}
