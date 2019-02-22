package com.xyz.vehicle.monitoring.entity.mysql;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by vinodjagwani on 22/01/19.
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle")
public class VehicleEntity extends AbstractBaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;

    @Column(nullable = false)
    private boolean status = false;

    @Column(nullable = false)
    private String registrationNo;

    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customerEntity;


}
