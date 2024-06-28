package uni.isw.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import uni.isw.service.ClienteService;
import uni.isw.model.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @Test
    public void testRegistrarCliente() throws Exception {
        Cliente cliente = new Cliente(1L, "Juan", "Perez", "Gomez", "juan.perez@example.com");

        // Mocking the saveOrUpdate method
        when(clienteService.saveOrUpdate(cliente)).thenReturn(cliente);

        mockMvc.perform(post("/api/v1/cliente/insertar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(cliente)))
                .andExpect(status().isCreated());
    }
}
