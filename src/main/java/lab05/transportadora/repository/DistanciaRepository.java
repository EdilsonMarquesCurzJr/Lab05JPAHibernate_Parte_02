package lab05.transportadora.repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.Cidade;
import lab05.transportadora.entity.Distancia;

import java.util.List;

public class DistanciaRepository {
    private final EntityManager manager;
    private DAO<Distancia> daoGenerico;

    public DistanciaRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAO<>(manager);
    }

    public Distancia buscaPor(Integer id) {
        return daoGenerico.buscaPorId(Distancia.class, id);
    }

    public List<Distancia> buscaTodas() {
        return this.manager.createQuery("from Distancia ", Distancia.class)
                .getResultList();
    }

    public Distancia distanciaEntreAB(Cidade a, Cidade b) {
        try {
            return this.manager.createQuery(
                "SELECT d FROM Distancia d WHERE d.origem = :cidadeOrigem AND d.destino = :cidadeDestino",
                Distancia.class)
                    .setParameter("cidadeOrigem", a)
                    .setParameter("cidadeDestino", b)
                    .getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

    public Distancia salvaOuAtualiza(Distancia distancia) {
        return daoGenerico.salvaOuAtualiza(distancia);
    }

    public void remove(Distancia distancia) {
        daoGenerico.remove(distancia);
    }
}
