package cl.edutecno.M1_EXAMENFINAL_SistemaClientes.servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.CategoriaEnum;
import cl.edutecno.M1_EXAMENFINAL_SistemaClientes.modelo.Cliente;

public class ArchivoServicio extends Exportador{

	//Metodos
	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Cliente> cargarDatos(String fileName) {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		String[] arrayData;
		
		try {
			File archivo = new File(fileName);
			if (archivo.exists()) {
				FileReader fr = new FileReader(archivo);
				BufferedReader br = new BufferedReader(fr);
				String data = br.readLine();
				
				while (data != null) {
					Cliente cliente = new Cliente();
					arrayData = data.split(",");
					cliente.setRunCliente(arrayData[0]);
					cliente.setNombreCliente(arrayData[1]);
					cliente.setApellidoCliente(arrayData[2]);
					cliente.setAniosCliente(arrayData[3]);
					System.out.println(cliente);
					cliente.setNombreCategoria(CategoriaEnum.valueOf(arrayData[4]));
					listaClientes.add(cliente);
					System.out.println(cliente);
					System.out.println("Datos cargados correctamente en la lista");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Ha ocurrido un error al importar los datos - " + e.getMessage());
		}
		return listaClientes;
	}
}
