package bean;

public class AtributosLDAP {

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getLdapRutaArbol() {
		return ldapRutaArbol;
	}
	public void setLdapRutaArbol(String ldapRutaArbol) {
		this.ldapRutaArbol = ldapRutaArbol;
	}
	public int getLdapPuerto() {
		return ldapPuerto;
	}
	public void setLdapPuerto(int ldapPuerto) {
		this.ldapPuerto = ldapPuerto;
	}
	public int getLdapVersion() {
		return ldapVersion;
	}
	public void setLdapVersion(int ldapVersion) {
		this.ldapVersion = ldapVersion;
	}
	public String getLdapHost() {
		return ldapHost;
	}
	public void setLdapHost(String ldapHost) {
		this.ldapHost = ldapHost;
	}
	
	private String usuario;
	private String login;
	private String pass;
	private String ldapRutaArbol;
	private int ldapPuerto;
	private int ldapVersion;
	private String ldapHost;
	
}
