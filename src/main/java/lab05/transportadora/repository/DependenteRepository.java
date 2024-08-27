package lab05.transportadora.repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.Dependente;

import java.util.List;

public class DependenteRepository {
    private final EntityManager manager;
    private DAO<Dependente> daoGenerico;

    public DependenteRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAO<Dependente>(manager);
    }

    public Dependente buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Dependente.class, id);
    }

    public List<Dependente> buscaPor(String nome) {
        return this.manager.createQuery("from Dependente " +
                        "where upper(nome) like :nome", Dependente.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public List<Dependente> buscaTodos() {
        return this.manager.createQuery("from Dependente ", Dependente.class)
                .getResultList();
    }

    public Dependente salvaOuAtualiza(Dependente dependente) {
        return daoGenerico.salvaOuAtualiza(dependente);
    }

    public void remove(Dependente dependente) {
        daoGenerico.remove(dependente);
    }
}
