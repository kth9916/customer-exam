package io.namoosori.jpa;

import io.namoosori.jpa.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CustomerJpaExam {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
//            Customer customer = new Customer("ID0004", "Hoo");
//            em.persist(customer); // INSERT X

            Customer customer4 = em.find(Customer.class, "ID0001");
//            customer4.setName("soo");
            System.out.println(customer4.toString());

            tx.commit();

        }catch (Exception e){
            tx.rollback();;
        }finally {
            em.close();
        }

        emf.close();
    }
}