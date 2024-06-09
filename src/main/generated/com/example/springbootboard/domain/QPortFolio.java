package com.example.springbootboard.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPortFolio is a Querydsl query type for PortFolio
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPortFolio extends EntityPathBase<PortFolio> {

    private static final long serialVersionUID = -45664906L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPortFolio portFolio = new QPortFolio("portFolio");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final QUser user;

    public QPortFolio(String variable) {
        this(PortFolio.class, forVariable(variable), INITS);
    }

    public QPortFolio(Path<? extends PortFolio> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPortFolio(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPortFolio(PathMetadata metadata, PathInits inits) {
        this(PortFolio.class, metadata, inits);
    }

    public QPortFolio(Class<? extends PortFolio> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

