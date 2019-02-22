package com.xyz.vehicle.monitoring.entity.mysql;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class CustomerEntity extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name = "customer_name")
    private String customerName;

    private String address;

}
