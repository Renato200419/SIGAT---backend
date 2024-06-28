package uni.isw.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import uni.isw.model.Cliente;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testSaveCliente() {
        Cliente cliente = new Cliente();
        cliente.setCliente_Nombre("Juan");
        cliente.setCliente_ApePaterno("Perez");
        cliente.setCliente_ApeMaterno("Gomez");
        cliente.setCliente_Correo("juan.perez@example.com");

        Cliente savedCliente = clienteRepository.save(cliente);
        assertNotNull(savedCliente);
    }
}
