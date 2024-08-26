package lab05.transportadora.Repository;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.PessoaFisica;

import java.util.List;

public class PessoaFisicaRepository {
    private final EntityManager manager;
    private DAO<PessoaFisica> daoGenerico;

    public PessoaFisicaRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAO<PessoaFisica>(manager);
    }

    public PessoaFisica buscaPor(Integer id) {
        return daoGenerico.buscaPorId(PessoaFisica.class, id);
    }

    public List<PessoaFisica> buscaPor(String nome) {
        return this.manager.createQuery("from PessoaFisica " +
                        "where upper(nome) like :nome", PessoaFisica.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public List<PessoaFisica> buscaTodos() {
        return this.manager.createQuery("from PessoaFisica ", PessoaFisica.class)
                .getResultList();
    }

    public PessoaFisica salvaOuAtualiza(PessoaFisica pessoaFisica) {
        return daoGenerico.salvaOuAtualiza(pessoaFisica);
    }

    public void remove(PessoaFisica pessoaFisica) {
        daoGenerico.remove(pessoaFisica);
    }
}
