package lab05.transportadora.Repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.Cliente;

public class ClienteRepository {
    private EntityManager em;
    private DAO<Cliente> dao;
    public ClienteRepository(EntityManager em) {
        this.em = em;
    }
    public Cliente findById(int id) {
        return dao.buscaPorId(Cliente.class,id);
    }

    public void salvarOuAtualizar(Cliente cliente){
        dao.salvaOuAtualiza(cliente);
    }


}
