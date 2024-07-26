package com.syntaxerror.demo;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.syntaxerror.demo.entity.Cliente;
import com.syntaxerror.demo.service.ClienteService;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private MockMvc mockmvc;
	
	@Test
	void contextLoads() throws Exception {
		testUnitarioCreacionCliente();
		testUnitarioObtencionCliente();
		testUnitarioActualizacionCliente();
		testUnitarioBorrarCliente();
		testIntegracionObtencionClientes();
	}
	
	public void testUnitarioCreacionCliente() throws Exception {
		
		Cliente clienteEsperado = new Cliente("1718943944", "Cesar Guzman", "M", 29, "Carcelen", "0998956588", 0, "123", true);
		Cliente clienteResultado = clienteService.crearOActualizarCliente(clienteEsperado);
		Assertions.assertEquals(clienteEsperado.getNombre(), clienteResultado.getNombre());
	}
	
	public void testUnitarioObtencionCliente() throws Exception {
		Cliente clienteResultado = clienteService.obtenerClientePorNombre("Cesar Guzman");
		Assertions.assertEquals("Cesar Guzman", clienteResultado.getNombre());
	}
	
	public void testUnitarioActualizacionCliente() throws Exception {
		Cliente clienteEsperado = clienteService.obtenerClientePorNombre("Cesar Guzman");
		clienteEsperado.setIdentificacion("1718943948");
		Cliente clienteResultado = clienteService.crearOActualizarCliente(clienteEsperado);
		Assertions.assertEquals("1718943948", clienteResultado.getIdentificacion());
	}
	
	public void testUnitarioBorrarCliente() throws Exception {
		Cliente clienteEsperado = clienteService.obtenerClientePorNombre("Cesar Guzman");
		Cliente clienteResultado = clienteService.borrarCliente(clienteEsperado.getClienteId());
		Assertions.assertEquals(clienteEsperado.getNombre(), clienteResultado.getNombre());
	}
	
	public void testIntegracionObtencionClientes() throws Exception {
		mockmvc.perform(MockMvcRequestBuilders.get("/clientes/obtenerClientes")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers
				.content()
				.contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}

}
