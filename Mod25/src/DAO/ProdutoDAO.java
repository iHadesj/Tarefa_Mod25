package DAO.Cliente;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import DAO.Generics.GenericDAO;
import Domain.Produto;

import java.util.HashMap;
import java.util.Map;

public class ProdutoDAO extends GenericDAO<Produto> implements DAO.Cliente.IProdutoDAO {

    @Override
    public Class<Produto> getTipoClasse() {
        return null;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {

    }

    @Override
    public void alterar(Produto entity) throws TipoChaveNaoEncontradaException {

    }
}