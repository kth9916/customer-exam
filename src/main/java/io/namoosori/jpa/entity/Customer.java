package io.namoosori.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="customer_tb")
public class Customer {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long registerDate;

    public Customer(long id, String name){
        this.id = id;
        this.name = name;
        this.registerDate = System.currentTimeMillis();
    }
    public static Customer sample(){
        return new Customer(1,"Kim");
    }
}
