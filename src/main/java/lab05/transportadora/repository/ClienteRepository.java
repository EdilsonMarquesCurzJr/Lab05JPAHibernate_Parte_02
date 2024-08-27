package lab05.transportadora.repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.Cliente;

public class ClienteRepository {
    private final EntityManager em;
    private DAO<Cliente> dao;

    public ClienteRepository(EntityManager em) {
        this.em = em;
        dao = new DAO<Cliente>(em);
    }
    public Cliente findById(int id) {
        return dao.buscaPorId(Cliente.class,id);
    }

    public void salvarOuAtualizar(Cliente cliente){
        dao.salvaOuAtualiza(cliente);
    }

    public void remove(Cliente cliente) {
        dao.remove(cliente);
    }

}
