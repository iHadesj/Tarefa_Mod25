package Test;


import DAO.Exceptions.TipoChaveNaoEncontradaException;
import DAO.Cliente.IClienteDAO;
import Domain.Cliente;
import Services.ClienteService;
import Services.IClienteService;
import Test.DaoMock.ClienteDaoMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteServiceTeste {

    private IClienteService clienteService;

    private Cliente cliente;

    public ClienteServiceTeste() {
        IClienteDAO dao = new ClienteDaoMock();
        clienteService = new ClienteService(dao);
    }

    @Before
    public void init() {
        cliente = new Cliente ();
        cliente.setCpf(12345678910L);
        cliente.setNome("Gustavo");
        cliente.setCidade("São Caetano do Sul");
        cliente.setEnd("Endereço");
        cliente.setEstado("SP");
        cliente.setNumero(10);
        cliente.setTel(11999999999L);
    }

    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);

        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Gustavo Mimesse");
        clienteService.alterar(cliente);

        Assert.assertEquals("Gustavo Mimesse", cliente.getNome());
    }

}