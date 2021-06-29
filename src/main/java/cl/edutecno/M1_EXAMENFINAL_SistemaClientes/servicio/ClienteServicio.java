package cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio;

import java.util.ArrayList;
import java.util.List;

import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.Cliente;

public class ClienteServicio {

	List<Cliente> listaCliente;

	// Metodos
	public void listarCliente() {
		// Ciclo para recorrer cada Cliente de listaCliente
	}

	public void agregarCliente(Cliente cliente) {
		// Guardar clientes en listaCliente
	}

	public void editarCliente() {
		// Editar cliente en listaCliente
	}

	// Constructores
	public ClienteServicio(List<Cliente> listaCliente) {
		this.listaCliente = new ArrayList<Cliente>();
	}

	// G&S
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

}
