package pruebashibernate;

public class HibernatePrincipal {

	public static void main(String[] args) {
		
		try {
			AccesoBD.setUp();
			Persona p=new Persona("Luis", "Sanz", "luis@mail.com");
			AccesoBD.insertarPersona(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

}

}
