package lab05.transportadora.Repository;

import com.mysql.cj.BindValue;
import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.EntidadeBase;

public class DAO <T extends EntidadeBase>{


    private final EntityManager manager;
    public DAO(EntityManager manager) {
        this.manager = manager;
    }

    T buscaPorId(Class<T> clazz, Integer id) {
            return manager.find(clazz, id);
        }

        T salvaOuAtualiza(T t) {
            BindValue Objects = null;
            if( Objects.isNull() )
                this.manager.persist(t);
            else
                t = this.manager.merge(t);
            return t;
        }

        void remove(T t) {
            manager.remove(t);
            manager.flush();
        }
    }