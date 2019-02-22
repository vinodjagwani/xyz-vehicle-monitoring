package com.xyz.vehicle.monitoring.entity.mysql;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCustomerEntity is a Querydsl query type for CustomerEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCustomerEntity extends EntityPathBase<CustomerEntity> {

    private static final long serialVersionUID = 654041174L;

    public static final QCustomerEntity customerEntity = new QCustomerEntity("customerEntity");

    public final QAbstractBaseEntity _super = new QAbstractBaseEntity(this);

    public final StringPath address = createString("address");

    //inherited
    public final DateTimePath<java.util.Date> createdTime = _super.createdTime;

    public final NumberPath<Long> customerId = createNumber("customerId", Long.class);

    public final StringPath customerName = createString("customerName");

    public QCustomerEntity(String variable) {
        super(CustomerEntity.class, forVariable(variable));
    }

    public QCustomerEntity(Path<? extends CustomerEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCustomerEntity(PathMetadata metadata) {
        super(CustomerEntity.class, metadata);
    }

}

