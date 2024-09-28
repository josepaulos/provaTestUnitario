package dao;

import modelo.Contato;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Classe de teste criada para garantir o funcionamento das principais funcionalidades
 * sobre Contatos, realizadas pela classe {@link GerenciadoraContatos}
 *
 * @author Guilherme Lopes e José Paulo Sappi
 * @date 27/09/2024
 */

public class GerenciadorContatoTest {
    private GerenciadoraContatos gerenciadoraContatos;
    private final int idContato1 = 1;
    private final int idContato2 = 2;

    //método para iniciar um cenário, a cada chamada de um método com @Test
    @Before
    public void setUp() {
        /*================ Fase1: Montagem do Cenário Global ================*/
        //criando alguns contatod
        Contato c1 = new Contato(idContato1, "Guilherme", "guilherme@gmail.com", "Oswaldo Cruz");
        Contato c2 = new Contato(idContato2, "José Paulo", "jose@gmail.com", "Miguel Couto");
        //inserindo os contato criados na lista de gerenciadoraContatos
        List<Contato> contatos = new ArrayList<>();
        contatos.add(c1);
        contatos.add(c2);
        gerenciadoraContatos = new GerenciadoraContatos(contatos);
    }

    //método para apagar o cenário constuído a cada chamada de um método com @Test
    @After
    public void tearDown() {
        //desmontagem do cenário global
        gerenciadoraContatos.limpa();
    }

    /**
     * Teste de pesquisa do contato por ID
     *
     * @author Guilherme Lopes e José Paulo Sappi
     * @date 27/09/2024
     */
    @Test
    public void testPesquisarContatoPorId() {
        /*================ Fase2: Execucao do Teste ================*/
        Contato contato = gerenciadoraContatos.pesquisarContatoPorId(idContato1);
        /*================ Fase3: verificação e Análise ================*/
        assertThat(contato.getId(), is(idContato1));
        assertThat(contato.getNome(), is("Guilherme"));
        assertThat(contato.getEmail(), is("guilherme@gmail.com"));
        assertThat(contato.getEndereco(), is("Oswaldo Cruz"));
    }

    /**
     * Teste de pesquisa do contato por um ID que não existe
     *
     * @author Guilherme Lopes e José Paulo Sappi
     * @date 27/09/2024
     */
    @Test
    public void testPesquisarContatoPorIdInexistente() {
        /*================ Fase2: Execucao do Teste ================*/
        Contato contato = gerenciadoraContatos.pesquisarContatoPorId(45);
        Contato contato2 = gerenciadoraContatos.pesquisarContatoPorId(-9945);
        /*================ Fase3: verificação e Análise ================*/
        assertNull(contato);
        assertNull(contato2);
    }

    /**
     * Teste de adicionar um novo contato a lista de contatos, usando um contato com id que não existe na lista
     *
     * @author Guilherme Lopes e José Paulo Sappi
     * @date 27/09/2024
     */
    @Test
    public void testAdicionarContato(){
        /*================ Fase2: Execucao do Teste ================*/
        int antes = gerenciadoraContatos.getContatos().size();
        int idContato3 = 3;
        Contato contato3 = new Contato(idContato3, "Cleiton", "claytonchagas1@gmail", "Sua casa professor");
        boolean resultado = gerenciadoraContatos.adicionarContato(contato3);
        Contato contato4 = gerenciadoraContatos.pesquisarContatoPorId(idContato3);
        int depois = gerenciadoraContatos.getContatos().size();
        boolean compararacao = antes == depois;
        /*================ Fase3: verificação e Análise ================*/
        assertTrue(resultado);
        assertThat(contato4.getId(), is(idContato3));
        assertTrue(!compararacao);
    }

    /**
     * Teste de adicionar um novo contato a lista de contatos, usando um contato com id que já existe na lista
     *
     * @author Guilherme Lopes e José Paulo Sappi
     * @date 27/09/2024
     */
    @Test
    public void testAdicionarContatoExistente(){
        /*================ Fase2: Execucao do Teste ================*/
        int antes = gerenciadoraContatos.getContatos().size();
        Contato contato5 = new Contato(idContato1, "Cleiton", "claytonchagas1@gmail", "Sua casa professor");
        boolean resultado = gerenciadoraContatos.adicionarContato(contato5);
        int depois = gerenciadoraContatos.getContatos().size();
        boolean compararacao = antes == depois;

        /*================ Fase3: verificação e Análise ================*/
        assertFalse(resultado);
        assertTrue(compararacao);
    }

    /**
     * Teste de adicionar um novo contato a lista de contatos, usando um contato com id que já existe na lista
     *
     * @author Guilherme Lopes e José Paulo Sappi
     * @date 27/09/2024
     */
    @Test
    public void testRemoverContato(){
        /*================ Fase2: Execucao do Teste ================*/
        int antes = gerenciadoraContatos.getContatos().size();
        boolean resultado = gerenciadoraContatos.removerContato(idContato2);
        int depois = gerenciadoraContatos.getContatos().size();
        boolean compararacao = antes == depois;
        Contato contato6 = gerenciadoraContatos.pesquisarContatoPorId(idContato2);
        /*================ Fase3: verificação e Análise ================*/
        assertTrue(resultado);
        assertFalse(compararacao);
        assertNull(contato6);
    }
    /**
     * Teste de adicionar um novo contato a lista de contatos, usando um contato com id que não existe na lista
     *
     * @author Guilherme Lopes e José Paulo Sappi
     * @date 27/09/2024
     */
    @Test
    public void testRemoverContatoInexistente(){
        /*================ Fase2: Execucao do Teste ================*/
        int idTemp= 556;
        int antes = gerenciadoraContatos.getContatos().size();
        boolean resultado = gerenciadoraContatos.removerContato(idTemp);
        int depois = gerenciadoraContatos.getContatos().size();
        boolean compararacao = antes == depois;
        Contato contato6 = gerenciadoraContatos.pesquisarContatoPorId(idTemp);
        /*================ Fase3: verificação e Análise ================*/
        assertFalse(resultado);
        assertTrue(compararacao);
        assertNull(contato6);
    }


















    }









