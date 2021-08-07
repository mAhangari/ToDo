package ir.maktab56.ToDo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import ir.maktab56.ToDo.util.*;


public class App 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = HibernateUtil.getEntityMangerFactory();
    	EntityManager entityManager = emf.createEntityManager();
    }
}
