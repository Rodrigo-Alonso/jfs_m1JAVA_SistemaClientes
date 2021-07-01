package cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio;

import java.util.List;

import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.Cliente;

public abstract class Exportador {

	// Metodos Abstractos
	public abstract void exportar(String fileName, List<Cliente> listaClientes);

}
