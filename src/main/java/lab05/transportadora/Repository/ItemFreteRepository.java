package lab05.transportadora.Repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.ItemFrete;

import java.util.List;

public class ItemFreteRepository {
    private final EntityManager manager;
    private DAO<ItemFrete> daoGenerico;

    public ItemFreteRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAO<ItemFrete>(manager);
    }

    public ItemFrete buscaPor(Integer id) {
        return daoGenerico.buscaPorId(ItemFrete.class, id);
    }

    public List<ItemFrete> buscaTodos() {
        return this.manager.createQuery("from ItemFrete ", ItemFrete.class)
                .getResultList();
    }

    public ItemFrete salvaOuAtualiza(ItemFrete itemFrete) {
        return daoGenerico.salvaOuAtualiza(itemFrete);
    }

    public void remove(ItemFrete itemFrete) {
        daoGenerico.remove(itemFrete);
    }
}
