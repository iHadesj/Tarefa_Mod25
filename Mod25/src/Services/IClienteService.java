package Services;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import Domain.Cliente;

public interface IClienteService {

    Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarPorCPF(Long cpf);

    void excluir(Long cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}