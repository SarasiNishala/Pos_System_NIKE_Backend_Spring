package lk.ijse.gdse68.nike_spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "customers")
@Entity
public class CustomerEntity implements Serializable {
    @Id
    private String customerId;
    private String name;
    private String address;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private int phone;
    @OneToMany(mappedBy = "customerEntity",cascade = CascadeType.ALL)
    private List<OrderEntity> orders;
}
