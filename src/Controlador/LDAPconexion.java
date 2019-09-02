package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;

import bean.AtributosLDAP;

public class LDAPconexion {

	
	public LDAPConnection getConexion() {
		archivo = new Properties();
		try {
			//Buscamos el archivo propiedades
			ruta = "C:/Users/juliorhode/Desktop/Proyectos/LDAP v2/atributosLDAP.properties";
			archivo.load(new FileReader(ruta));
			
			
			
			atributos = new AtributosLDAP();
			//Asignamos los valores al objeto AtributosLDAP
			atributos.setLdapRutaArbol(archivo.getProperty("ldapRutaArbol"));
			
			atributos.setLdapPuerto(Integer.parseInt(archivo.getProperty("ldapPuerto")));
			atributos.setLdapVersion(Integer.parseInt(archivo.getProperty("ldapVersion")));
			atributos.setLdapHost(archivo.getProperty("ldapHost"));
			//AtributosLDAP.setUsuario(archivo.getProperty("usuario"));
			atributos.setPass(archivo.getProperty("pass"));
			atributos.setLogin("cn=" + archivo.getProperty("usuario") + archivo.getProperty("ldapRutaArbol"));
			
			// Crear el objeto conexion para el LDAP
			con = new LDAPConnection();
			//Pasamos los parametros necesarios para la conexion al LDAP
			try {
				con.connect(atributos.getLdapHost(), atributos.getLdapPuerto());
				con.bind(atributos.getLdapVersion(),atributos.getLogin(),atributos.getPass().getBytes("UTF8"));
				attr = new LDAPAttribute("userPassword",atributos.getLogin());
				estado = con.compare(atributos.getLogin(), attr);
				
				//Verificamos si el pass esta correcto
				if(estado == false) {
					con = null;
				}
				
			} catch (LDAPException e) {
				// TODO Auto-generated catch block
				con = null;
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		LDAPconexion con = new LDAPconexion();
		con.getConexion();
		if(con == null) {
			System.out.println( "No se pudo conectar.");
		}else {
			System.out.println( "Estamos conectados.");
		}
	}
	
	private LDAPAttribute attr;
	private LDAPConnection con;
	private AtributosLDAP atributos;
	private Properties archivo;
	private String ruta;
	private boolean estado = false; // Esto lo uso para comparar el pass contra el LDAP
}

