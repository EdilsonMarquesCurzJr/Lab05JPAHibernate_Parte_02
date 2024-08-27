package lab05.transportadora.repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.EntidadeBase;

import java.util.Objects;

public class DAO <T extends EntidadeBase>{
    private final EntityManager manager;

    public DAO(EntityManager manager) {
        this.manager = manager;
    }

    T buscaPorId(Class<T> clazz, Integer id) {
            return manager.find(clazz, id);
        }

    T salvaOuAtualiza(T t) {
        if( Objects.isNull(t.getId()) )
            this.manager.persist(t);
        else
            t = this.manager.merge(t);
        return t;
    }

    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }
    /*
    * EntityTransaction transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.remove(manager.contains(t) ? t : manager.merge(t)); // Remover de forma segura
            manager.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }*/
}