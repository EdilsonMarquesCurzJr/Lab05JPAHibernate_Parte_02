package lab05.transportadora.Repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.Filial;

import java.util.List;

public class FilialRepository {
    private final EntityManager manager;
    private DAO<Filial> daoGenerico;

    public FilialRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAO<Filial>(manager);
    }

    public Filial buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Filial.class, id);
    }

    public List<Filial> buscaPor(String nome) {
        return this.manager.createQuery("from Filial " +
                        "where upper(nome) like :nome", Filial.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public List<Filial> buscaTodas() {
        return this.manager.createQuery("from Filial ", Filial.class)
                .getResultList();
    }

    public Filial salvaOuAtualiza(Filial filial) {
        return daoGenerico.salvaOuAtualiza(filial);
    }

    public void remove(Filial filial) {
        daoGenerico.remove(filial);
    }
}
