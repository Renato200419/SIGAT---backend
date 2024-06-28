package uni.isw.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uni.isw.repository.ClienteRepository;
import uni.isw.model.Cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteServiceTest {

    @Autowired
    private ClienteService clienteService;

    @MockBean
    private ClienteRepository clienteRepository;

    @Test
    public void testRegistrarCliente() {
        Cliente cliente = new Cliente(1L, "Juan", "Perez", "Gomez", "juan.perez@example.com");

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        clienteService.saveOrUpdate(cliente);
        assertEquals("Juan", cliente.getCliente_Nombre());
    }
}
