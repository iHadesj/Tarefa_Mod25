package DAO.Generics;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import Domain.Persistente;

import java.util.Collection;

public interface IGenericDAO <T extends Persistente> {

    public Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;


    public void excluir (Long valor);


    public void alterar (T entity) throws TipoChaveNaoEncontradaException;


    public T consultar(Long valor);


    Collection<T> buscarTodos();
}