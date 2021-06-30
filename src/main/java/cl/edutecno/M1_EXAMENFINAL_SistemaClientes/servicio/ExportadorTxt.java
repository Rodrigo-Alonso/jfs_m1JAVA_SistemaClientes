package cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.Cliente;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.utilidades.Utilidad;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.vista.Menu;

public class ExportadorTxt extends Exportador {

	// Metodos
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		Menu menu = new Menu();
		Utilidad utilidad = new Utilidad();
		try {
			File archivo = new File(fileName);
			if (utilidad.comprobarFichero(archivo)) {
				archivo.createNewFile();
				FileWriter fw = new FileWriter(archivo);
				BufferedWriter bw = new BufferedWriter(fw);

				for (Cliente cliente : listaClientes) {
					bw.write(cliente.getRunCliente() + "," + cliente.getNombreCliente() + ","
							+ cliente.getApellidoCliente() + "," + cliente.getAniosCliente() + ","
							+ cliente.getNombreCategoria() + "\n");
				}
				bw.close();
				System.out.println("-------------------------------------------");
				System.out.println("Datos de clientes exportados correctamente en formato .txt");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en exportado de datos a .txt: " + e.getMessage());
			menu.exportarDatos();
		}

	}

}
