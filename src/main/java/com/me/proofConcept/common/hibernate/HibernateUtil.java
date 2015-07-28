package com.me.proofConcept.common.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
 
public class HibernateUtil {

	private static SessionFactory sessionFactory ;
    
	static {
	   	Configuration configuration = new Configuration().configure();
	   	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
	   			applySettings(configuration.getProperties());
	       sessionFactory = configuration.buildSessionFactory(builder.build());
	       
	       Runtime rt = Runtime.getRuntime();
	       rt.addShutdownHook(new ShutdownHook());
    }
   
    
    public static SessionFactory getSessionFactory() {
       return sessionFactory;
    }
    
    public static class ShutdownHook extends Thread {
        public void run() {
        	if(sessionFactory != null) {
        		sessionFactory.close();
        	}
        }
     }

}