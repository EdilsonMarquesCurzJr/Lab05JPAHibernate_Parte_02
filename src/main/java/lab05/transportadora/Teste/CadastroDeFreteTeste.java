package lab05.transportadora.Teste;

import jakarta.persistence.EntityManager;
import lab05.transportadora.entity.*;
import lab05.transportadora.service.CadastroDeFreteService;
import lab05.transportadora.util.EMFactory;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class CadastroDeFreteTeste {
    public static void main(String[] args) {
        // manager
        EntityManager em = new EMFactory().getEntityManager();
        // service
        CadastroDeFreteService service = new CadastroDeFreteService();

        // Transação para persistir as entidades relacionadas
        em.getTransaction().begin();
        try {
            // Objetos
            Cliente cliente = Cliente.builder()
                    .nome("Pedro")
                    .cpf("12345678")
                    .telefone("98988123456")
                    .email("pedro@ifma.com")
                    .contato("98988123456")
                    .ativo(true)
                    .build();

            Filial filial = new Filial("Entregas Maranhão", "Rua da Saudade", "98940028922");

            Funcionario funcionario = Funcionario.builder()
                    .nome("Joaquim")
                    .cpf("98745632154")
                    .telefone("98978945612")
                    .email("joaquim@gmail.com")
                    .matricula(1234)
                    .filial(filial)
                    .build();

            ItemFrete itemFrete1 = new ItemFrete("Abacate", 500);
            ItemFrete itemFrete2 = new ItemFrete("Banana", 100);
            ItemFrete itemFrete3 = new ItemFrete("Pedra de Responsa", 9999);

            CategoriaFrete categoriaFrete1 = new CategoriaFrete("Normal", "X dias uteis", 0);
            CategoriaFrete categoriaFrete2 = new CategoriaFrete("Super-rápido", "Sabe o Flash?", 30);

            Cidade cidadeOrigem1 = new Cidade("Miranda", "MA");
            Cidade cidadeDestino1 = new Cidade("São Luís", "MA");
            Cidade cidadeOrigem2 = new Cidade("Bacabal", "MA");

            Distancia distancia1 = new Distancia(400,cidadeOrigem1,cidadeDestino1);
            Distancia distancia2 = new Distancia(300,cidadeOrigem2,cidadeDestino1);

            TipoVeiculo tipoVeiculo = new TipoVeiculo("Ford Ka", 700);

            Veiculo veiculo = new Veiculo("NHO-1234", tipoVeiculo, filial);

            em.persist(cliente);
            em.persist(filial);
            em.persist(funcionario);
            em.persist(categoriaFrete1);
            em.persist(categoriaFrete2);
            em.persist(cidadeOrigem1);
            em.persist(cidadeDestino1);
            em.persist(cidadeOrigem2);
            em.persist(distancia1);
            em.persist(distancia2);
            em.persist(tipoVeiculo);
            em.persist(veiculo);

            // Persistindo o frete sem itens inicialmente
            Frete frete1 = Frete.builder()
                    .itemFretes(new LinkedList<>())  // Sem itens no início
                    .categoria(categoriaFrete1)
                    .cidadeOrigem(cidadeOrigem1)
                    .cidadeDestino(cidadeDestino1)
                    .cliente(cliente)
                    .funcionario(funcionario)
                    .numeroNotaFiscal(1)
                    .valorKmRodado(new BigDecimal(400))
                    .veiculo(veiculo)
                    .build();

            Frete frete2 = Frete.builder()
                    .itemFretes(new LinkedList<>())  // Sem itens no início
                    .categoria(categoriaFrete2)
                    .cidadeOrigem(cidadeOrigem2)
                    .cidadeDestino(cidadeDestino1)
                    .cliente(cliente)
                    .funcionario(funcionario)
                    .numeroNotaFiscal(2)
                    .valorKmRodado(new BigDecimal(400))
                    .veiculo(veiculo)
                    .build();

            em.persist(frete1);
            em.persist(frete2);

            // Atualizando os ItemFrete com o frete correspondente
            itemFrete1.setFrete(frete1);
            itemFrete2.setFrete(frete1);
            itemFrete3.setFrete(frete2);

            em.persist(itemFrete1);
            em.persist(itemFrete2);
            em.persist(itemFrete3);

            // Atualizar o frete com os itens
            frete1.getItemFretes().add(itemFrete1);
            frete1.getItemFretes().add(itemFrete2);
            frete2.getItemFretes().add(itemFrete2);  // Assumindo que o mesmo itemFrete2 pode ser adicionado a frete2
            frete2.getItemFretes().add(itemFrete3);

            // Sincronizar o estado atualizado no banco
            em.merge(frete1);
            em.merge(frete2);

            em.getTransaction().commit();

            System.out.println("Cadastrando o frete: " + service.registrarFrete(frete1).getId() + "\n");
            System.out.println("Cadastrando o frete: " + service.registrarFrete(frete2).getId() + "\n");
            System.out.println("Valor do frete 1: R$ " + service.calcularValorFrete(frete1) + "\n");
        } catch (Exception e) {
            //em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        // Testes

        System.out.println("Detalhes do Frete1: " + service.buscarFrete(1) + "\n");
        List<Frete> resultados = service.listarFretesPorCliente(Cliente.builder().id(1).build());
        for (Frete frete : resultados) {
           System.out.println(frete.toString() + "\n");
        }
    }
}
