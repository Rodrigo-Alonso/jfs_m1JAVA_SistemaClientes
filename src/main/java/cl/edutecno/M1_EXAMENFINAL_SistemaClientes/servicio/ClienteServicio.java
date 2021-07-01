package cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.CategoriaEnum;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.Cliente;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.vista.Menu;

public class ClienteServicio {

	List<Cliente> listaCliente;
	Scanner scI = new Scanner(System.in);
	Scanner scS = new Scanner(System.in);

	// Metodos
	public void listarCliente() {
		Menu menu = new Menu();

		try {
			if (listaCliente.size() != 0 && listaCliente != null) {

				for (Cliente cliente : listaCliente) {
					System.out.println("");
					System.out.println("-------------DATOS DEL CLIENTE-------------");
					System.out.println("");
					System.out.printf("Run del cliente: %s\n", cliente.getRunCliente());
					System.out.printf("Nombre del cliente: %s\n", cliente.getNombreCliente());
					System.out.printf("Apellido del cliente: %s\n", cliente.getApellidoCliente());
					System.out.printf("Años como cliente: %s\n", cliente.getAniosCliente());
					System.out.printf("Categoria del cliente: %s\n", cliente.getNombreCategoria());
					System.out.println("");
					System.out.println("-------------------------------------------");
				}

			} else {
				System.out.println("No se puede listar alumnos");
				System.out.println("-------------------------------------------");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en ejecucion Listar Cliente: " + e.getMessage());
			menu.iniciarMenu(scI);
		}
	}

	public void agregarCliente(Cliente cliente) {

		if (listaCliente != null) {
			listaCliente.add(cliente);
		} else {
			listaCliente = new ArrayList<Cliente>();
			listaCliente.add(cliente);
		}
		System.out.println("");
		System.out.println("Cliente creado");

	}

	public void editarCliente(int opcion) {
		int opcion2;
		int opcion3;
		String rut;

		System.out.print("Ingrese RUN del cliente a editar: ");
		rut = verificaRut(scS.nextLine());
		

		switch (opcion) {
		case 1:
			System.out.println("------Actualizando estado del cliente------");
			
			for (Cliente clienteTemp : listaCliente) {
				if (clienteTemp.getRunCliente().equalsIgnoreCase(rut)) {
					System.out.printf("El estado actual es: %s\n", clienteTemp.getNombreCategoria());
					if (clienteTemp.getNombreCategoria() == CategoriaEnum.ACTIVO) {
						System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
						System.out.println("2.-Si desea mantener el estado del cliente Activo");
						System.out.println("");
						System.out.print("Ingrese opcion: ");
						opcion2 = scI.nextInt();
						if (opcion2 == 1) {
							clienteTemp.setNombreCategoria(CategoriaEnum.INACTIVO);
						}
					} else if (clienteTemp.getNombreCategoria() == CategoriaEnum.INACTIVO) {
						System.out.println("1.-Si desea cambiar el estado del Cliente a Activo");
						System.out.println("2.-Si desea mantener el estado del cliente Inactivo");
						System.out.println("");
						System.out.print("Ingrese opcion: ");
						opcion2 = scI.nextInt();
						if (opcion2 == 1) {
							clienteTemp.setNombreCategoria(CategoriaEnum.ACTIVO);
						}
					} else {
						System.out.println("No se puedo cambiar el estado del cliente");
					}
				}
			}
			break;
			
		case 2:
			System.out.println("-------Actualizando datos del cliente------");
			System.out.println("");
			listaCliente.stream().filter(cliente -> cliente.getRunCliente().equalsIgnoreCase(rut))
					.forEach(i -> System.out.println("1.-El Run del cliente es: " + i.getRunCliente() + "\n"
							+ "2.-El nombre del Cliente es: " + i.getNombreCliente() + "\n"
							+ "3.-El Apellido del Cliente es: " + i.getApellidoCliente() + "\n"
							+ "4.-Los años como Cliente son: " + i.getAniosCliente()));

			System.out.println("");
			System.out.print("Ingrese opcion a editar de los datos del cliente: ");
			opcion3 = scI.nextInt();
			System.out.println("-------------------------------------------");
			switch (opcion3) {
			case 1:
				System.out.print("1.-Ingrese nuevo RUN del Cliente: ");
				listaCliente.stream().filter(cliente -> cliente.getRunCliente().equalsIgnoreCase(rut))
						.forEach(i -> i.setRunCliente(scS.nextLine()));
				System.out.println("-------------------------------------------");
				System.out.println("Datos cambiados con éxito");
				break;
			case 2:
				System.out.print("1.-Ingrese nuevo Nombre del Cliente: ");
				listaCliente.stream().filter(cliente -> cliente.getRunCliente().equalsIgnoreCase(rut))
						.forEach(i -> i.setNombreCliente(scS.nextLine()));
				System.out.println("-------------------------------------------");
				System.out.println("Datos cambiados con éxito");
				break;
			case 3:
				System.out.print("1.-Ingrese nuevo Apellido del Cliente: ");
				listaCliente.stream().filter(cliente -> cliente.getRunCliente().equalsIgnoreCase(rut))
						.forEach(i -> i.setApellidoCliente(scS.nextLine()));
				System.out.println("-------------------------------------------");
				System.out.println("Datos cambiados con éxito");
				break;
			case 4:
				System.out.print("1.-Ingrese nuevos años del Cliente: ");
				listaCliente.stream().filter(cliente -> cliente.getRunCliente().equalsIgnoreCase(rut))
						.forEach(i -> i.setAniosCliente(scS.nextLine() + " años"));
				System.out.println("-------------------------------------------");
				System.out.println("Datos cambiados con éxito");
				break;
			default:
				System.out.println("-------------OPCION NO VALIDA--------------");
				break;
			}
			break;
		default:
			System.out.println("--------------OPCION NO VALIDA-------------");
			break;
		}
		

	}

	public String verificaRut(String rut) {
		boolean condition = true;
		//rut = rut.replace(".", "");
		
		do {
			for (Cliente cliente : listaCliente) {
				if (cliente.getRunCliente().equalsIgnoreCase(rut)) {
					condition = false;
				} 
			}
			
			System.out.println("");
			System.out.printf("RUN del Cliente '%s' no encontrado, favor de volver a ingresar: ", rut);
			rut = scS.nextLine();
		} while (condition);

		return rut;
	}

	// Constructores
	public ClienteServicio(List<Cliente> listaCliente) {
		this.listaCliente = new ArrayList<Cliente>();
	}

	public ClienteServicio() {
		super();
	}

	// G&S
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

}
