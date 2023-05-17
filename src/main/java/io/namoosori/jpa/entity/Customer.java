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
@SequenceGenerator(
        name="customer_generator",
        sequenceName = "customer_seq",
        initialValue = 1,
        allocationSize = 50
)
public class Customer {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
//    @SequenceGenerator(name = "my_seq", sequenceName = "db_seq") : db에 저장되어 있는 sequence를 가져와서 id를 만들 때
    private Long id;
    private String name;
    private long registerDate;

    public Customer(Long id, String name){
        this.id = id;
        this.name = name;
        this.registerDate = System.currentTimeMillis();
    }
    public static Customer sample(){
        return new Customer(1L,"Kim");
    }
}
