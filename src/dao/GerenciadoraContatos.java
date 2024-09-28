package dao;

import modelo.Contato;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GerenciadoraContatos {

    private List<Contato> contatos;

    public List<Contato> getContatos() {
        return contatos;
    }

    public GerenciadoraContatos(@NotNull final List<Contato> contatos) {
        this.contatos = contatos;
    }
    public GerenciadoraContatos() {}

    //pesquisa
    public Contato pesquisarContatoPorId (final int idContato) {
        for (Contato contato : contatos) {
            if(contato.getId() == idContato)
                return contato;
        }
        return null;
    }
    //adciona
    public boolean adicionarContato (@NotNull final Contato novoContato) {
        boolean contatoAdicionado = false;
        for (Contato contato : contatos) {
            if(contato.getId() == novoContato.getId())
                return contatoAdicionado;
        }
        contatos.add(novoContato);
        contatoAdicionado = true;
        return contatoAdicionado;
    }
    //remove
    public boolean removerContato (final int idContato) {
        boolean contatoRemovido = false;

        if(this.pesquisarContatoPorId(idContato) != null){
            contatos.remove(idContato-1);
            contatoRemovido = true;
        }

        return contatoRemovido;
    }
    /**
     * Limpa a lista de clientes, ou seja, remove todos eles.
     */
    public void limpa() {
        this.contatos.clear();
    }
}
