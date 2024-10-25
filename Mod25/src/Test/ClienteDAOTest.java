package Test;

import DAO.Exceptions.TipoChaveNaoEncontradaException;
import DAO.Cliente.IClienteDAO;
import Domain.Cliente;
import Test.DaoMock.ClienteDaoMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        cliente = new Cliente ();
        cliente.setCpf(12345678910L);
        cliente.setNome("Gustavo");
        cliente.setCidade("São Caetano do Sul");
        cliente.setEnd("Endereço");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(11999999999L);
        clienteDao.cadastrar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteDao.cadastrar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteDao.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Gustavo Mimesse");
        clienteDao.alterar(cliente);

        Assert.assertEquals("Gustavo Mimesse", cliente.getNome());
    }
}