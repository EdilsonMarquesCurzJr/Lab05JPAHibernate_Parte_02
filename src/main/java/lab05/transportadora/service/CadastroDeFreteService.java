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

public class CadastroDeFreteService {
    private final FreteRepository repositorio;
    private final EntityManager manager;

    public CadastroDeFreteService(){

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

    public Double calcularValorFrete(Frete frete) {
        try {
            if (frete == null || frete.getCidadeOrigem() == null || frete.getCidadeDestino() == null) {
                throw new IllegalArgumentException("Frete ou cidades de origem e destino não podem ser nulos.");
            }

            DistanciaRepository distanciaRepository = new DistanciaRepository(manager);
            Distancia distanciaAB = distanciaRepository.distanciaEntreAB(frete.getCidadeOrigem(), frete.getCidadeDestino());

            if (distanciaAB == null) {
                throw new RuntimeException("Distância entre " + frete.getCidadeOrigem() + " e " + frete.getCidadeDestino() + " não encontrada.");
            }

            CategoriaFrete categoriaFrete = frete.getCategoria();
            double percentualAdicional = categoriaFrete.getPercentualAdicional();
            double valorSemAdicional = frete.getValorKmRodado().doubleValue() * distanciaAB.getQuilometros();
            if (percentualAdicional == 0) {
                return valorSemAdicional;
            }

            return valorSemAdicional + (valorSemAdicional * (percentualAdicional / 100.0));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao calcular o valor do frete: " + e.getMessage(), e);
        }
    }


    public List<Frete> listarFretesPorCliente(Cliente cliente){
        return repositorio.listaFretesPorClienteId(cliente.getId());
    }
    public Frete buscarFrete(int id){
        return repositorio.buscaPor(id);
    }
    
}
