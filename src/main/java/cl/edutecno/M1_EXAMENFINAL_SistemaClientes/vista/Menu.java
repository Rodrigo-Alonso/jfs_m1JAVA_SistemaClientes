package cl.edutecno.M1_EXAMENFINAL_SistemaClientes.vista;

import java.util.List;
import java.util.Scanner;

import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.CategoriaEnum;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.Cliente;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio.ArchivoServicio;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio.ClienteServicio;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio.ExportadorCsv;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio.ExportadorTxt;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.utilidades.Utilidad;

public class Menu {

	private String fileName = "Clientes";
	private String fileName1 = "DBClientes.csv";
	ClienteServicio clienteServicio = new ClienteServicio(null);
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportadorCsv exportadorCsv = new ExportadorCsv();
	ExportadorTxt exportarTxt = new ExportadorTxt();
	static Scanner scI = new Scanner(System.in);
	static Scanner scS = new Scanner(System.in);

	// Metodos
	public void iniciarMenu(Scanner scI) {
		
		List<Cliente> listaClientes = clienteServicio.getListaCliente();
		
		try {
			int opcion;
			do {
				System.out.println("1. Listar Clientes");
				System.out.println("2. Agregar Clientes");
				System.out.println("3. Editar Cliente");
				System.out.println("4. Cargar Datos");
				System.out.println("5. Exportar Datos");
				System.out.println("6. Salir");
				System.out.print("Seleccion: ");
				opcion = scI.nextInt();

				switch (opcion) {
				case 1:
					listarCliente(listaClientes);
					break;
				case 2:
					agregarCliente(listaClientes);
					break;
				case 3:
					editarCliente();
					break;
				case 4:
					importarDatos();
					break;
				case 5:
					exportarDatos();
					break;
				case 6:
					terminarPrograma();
					break;
				default:
					System.out.println("---------------OPCION NO VALIDA---------------");
					break;
				}

			} while (opcion != 6);

		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Caracter no valido: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en ejecucion menu: " + e.getMessage());
		}

	}

	public void listarCliente(List<Cliente> listaClientes) {
		
		try {
			if (listaClientes.size() != 0) {
				
				for (Cliente cliente : listaClientes) {
					System.out.println("");
					System.out.println("---------------DATOS DEL CLIENTE---------------");
					System.out.println("");
					System.out.printf("Run del cliente: %s\n", cliente.getRunCliente());
					System.out.printf("Nombre del cliente: %s\n", cliente.getNombreCliente());
					System.out.printf("Apellido del cliente: %s\n", cliente.getApellidoCliente());
					System.out.printf("Años como cliente: %s años\n", cliente.getAniosCliente());
					System.out.printf("Categoria del cliente: %s\n", cliente.getNombreCategoria());
					System.out.println("");
					System.out.println("------------------------------------------------");
				}
				
			}else {
				System.out.println("No se puede listar alumnos");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en ejecucion Listar Cliente: " + e.getMessage());
		}
		
		System.out.println("");
	}

	public List<Cliente> agregarCliente(List<Cliente> listaClientes) {

		String dato = "";
		Cliente cliente = new Cliente();

		try {

			System.out.println("");
			System.out.println("---------------CREAR CLIENTE---------------");
			System.out.println("");
			System.out.print("Ingrese RUN del Cliente: ");
			dato = scS.nextLine();
			cliente.setRunCliente(dato);
			System.out.print("Ingrese Nombre del Cliente: ");
			dato = scS.nextLine();
			cliente.setNombreCliente(dato);
			System.out.print("Ingrese Apellido del Cliente: ");
			dato = scS.nextLine();
			cliente.setApellidoCliente(dato);
			System.out.print("Ingrese años como Cliente: ");
			dato = scS.nextLine();
			cliente.setAniosCliente(dato);
			cliente.setNombreCategoria(CategoriaEnum.ACTIVO);// Por defecto al crear cliente
			
			listaClientes.add(cliente);//Se agrega cliente en listaClientes
			//clienteServicio.agregarCliente(listaClientes, cliente);
			System.out.println("");
			System.out.println("Cliente creado");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en ejecucion Crear Cliente: " + e.getMessage());
		}
		
		System.out.println("-----------------------------------------");
		System.out.println("");
		return listaClientes;
	}

	public void editarCliente() {
		// Permite la edicion de algun cliente en caso de requerirlo o cambiar el estado
		// del cliente.
		System.out.println("Metodo editarCliente");
	}

	public void importarDatos() {
		// Ejecuta la carga de datos del archivo "DBCLientes.csv"
		System.out.println("Metodo impotarDatos");
	}

	public void exportarDatos() {
		// Llama a metodo para exportar clientes en formato ".txt" O ".csv"
		System.out.println("Metodo exportarDatos");
	}

	public void terminarPrograma() {

		Utilidad utilidad = new Utilidad();

		utilidad.tiempoEspera();
		utilidad.limpiezaPantalla();

	}

}
