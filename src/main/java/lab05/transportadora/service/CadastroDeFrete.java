package lab05.transportadora.service;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.CategoriaFrete;
import lab05.transportadora.entity.Cliente;
import lab05.transportadora.entity.Distancia;
import lab05.transportadora.entity.Frete;
import lab05.transportadora.repository.DistanciaRepository;
import lab05.transportadora.repository.FreteRepository;
import lab05.transportadora.util.EMFactory;

import java.util.List;

public class CadastroDeFrete {
    private final FreteRepository repositorio;
    private final EntityManager manager;

    public CadastroDeFrete(){

        this.manager = new EMFactory().getEntityManager();
        this.repositorio = new FreteRepository(manager);

    }

    public Frete registrarFrete(Frete frete){
        try{
            manager.getTransaction().begin();
            Frete freteSalvo = repositorio.salvaOuAtualiza(frete);
            manager.getTransaction().commit();

            return freteSalvo;
        }
        catch(Exception e){
            manager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public Double calcularValorFrete(Frete frete){
        DistanciaRepository distanciaRepository= new DistanciaRepository(manager);
        Distancia distanciaAB;
        CategoriaFrete categoriaFrete = frete.getCategoria();

        distanciaAB = distanciaRepository.distanciaEntreAB(frete.getCidadeOrigem(), frete.getCidadeDestino());
        // distância * percentual
        return (double)distanciaAB.getQuilometros() * (categoriaFrete.getPercentualAdicional()/100.0);
    }

    public List<Frete> listarFretesPorCliente(Cliente cliente){
        return repositorio.listaFretesPorClienteId(cliente.getId());
    }
    public Frete BuscarFrete(int id){
        return repositorio.buscaPor(id);
    }
    
}
