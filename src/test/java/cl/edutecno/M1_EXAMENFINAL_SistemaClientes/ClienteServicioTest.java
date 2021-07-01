package cl.edutecno.M1_EXAMENFINAL_SistemaClientes;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.CategoriaEnum;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.Cliente;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio.ClienteServicio;

public class ClienteServicioTest {

	private static final String RUT_STRING = "11.111.111-1", NOMBRE_STRING = "RODRIGO", APELLIDO_STRING = "PEREIRA";
	private static final CategoriaEnum CATEGORIA_ENUM = CategoriaEnum.ACTIVO;
	private static Logger logger = Logger.getLogger("cl.edutecno.M1_EXAMENFINAL_SistemaClientes");
	private static ClienteServicio clienteServicio;
	private static Cliente cliente;
	
	@BeforeAll
	public static void setUp() {
		cliente = new Cliente();
		clienteServicio = new ClienteServicio();
	}
	
	@Test
	@DisplayName("Test Agregar Cliente")
	public void agregarClienteTest() {
		logger.info("Informacion test Agregar Cliente");
		cliente.setRunCliente(RUT_STRING);
		cliente.setNombreCliente(NOMBRE_STRING);
		cliente.setApellidoCliente(APELLIDO_STRING);
		cliente.setNombreCategoria(CATEGORIA_ENUM);
		clienteServicio.agregarCliente(cliente);
		
		assertEquals(clienteServicio.getListaCliente().get(0).getNombreCliente(), "RODRIGO");
	}
	
	@Test
	@DisplayName("Test Agregar Cliente Null")
	public void agregarClienteNullTest() {
		logger.info("Informacion test Agregar Cliente Null");
		clienteServicio.agregarCliente(cliente);
		assertNull(clienteServicio.getListaCliente().get(0).getNombreCliente(), null);
	}
	
	
	

}
