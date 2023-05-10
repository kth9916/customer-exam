package io.namoosori.jpa;

import io.namoosori.jpa.entity.Customer;
import jakarta.persistence.*;

import java.util.List;

public class CustomerJpaExam {

    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("customer-exam");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            /* @GeneratedValue(strategy = GenerationType.IDENTITY) 일 때 */
            Customer customer = new Customer(); // 비영속 상태(new)
            customer.setName("kim");
            customer.setRegisterDate(System.currentTimeMillis());
            em.persist(customer);   // 영속 상태 (Managed)

            System.out.println(customer.getName());

            System.out.println("=========before commit=========");

            System.out.println(customer.getName());


            tx.commit();

        }catch (Exception e){
            tx.rollback();;
        }finally {
            em.close();
        }

        emf.close();
    }
}