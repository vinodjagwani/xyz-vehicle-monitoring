package com.xyz.vehicle.monitoring.entity.mysql;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVehicleEntity is a Querydsl query type for VehicleEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVehicleEntity extends EntityPathBase<VehicleEntity> {

    private static final long serialVersionUID = -799953766L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVehicleEntity vehicleEntity = new QVehicleEntity("vehicleEntity");

    public final QAbstractBaseEntity _super = new QAbstractBaseEntity(this);

    //inherited
    public final DateTimePath<java.util.Date> createdTime = _super.createdTime;

    public final QCustomerEntity customerEntity;

    public final StringPath registrationNo = createString("registrationNo");

    public final BooleanPath status = createBoolean("status");

    public final NumberPath<Long> vehicleId = createNumber("vehicleId", Long.class);

    public QVehicleEntity(String variable) {
        this(VehicleEntity.class, forVariable(variable), INITS);
    }

    public QVehicleEntity(Path<? extends VehicleEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVehicleEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVehicleEntity(PathMetadata metadata, PathInits inits) {
        this(VehicleEntity.class, metadata, inits);
    }

    public QVehicleEntity(Class<? extends VehicleEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.customerEntity = inits.isInitialized("customerEntity") ? new QCustomerEntity(forProperty("customerEntity")) : null;
    }

}

