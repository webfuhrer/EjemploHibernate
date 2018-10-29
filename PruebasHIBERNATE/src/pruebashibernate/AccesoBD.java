package pruebashibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AccesoBD {
	
		private static SessionFactory sessionFactory;

		
		public static void setUp() throws Exception {
			// A SessionFactory is set up once for an application!
			final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
					.configure() // configures settings from hibernate.cfg.xml
					.build();
			try {
				sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
			}
			catch (Exception e) {
				// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
				// so destroy it manually.
				System.out.println(e.getMessage());
				StandardServiceRegistryBuilder.destroy( registry );
			}
		}
		public static void insertarPersona(Persona p)
		{
			Session s=sessionFactory.openSession();
			s.beginTransaction();
			s.save(p);
			s.getTransaction().commit();
		}
		
}
