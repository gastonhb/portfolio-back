package com.portfolio.back.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SkillType.class)
public abstract class SkillType_ {

	public static volatile SingularAttribute<SkillType, String> name;
	public static volatile SingularAttribute<SkillType, UUID> id;

	public static final String NAME = "name";
	public static final String ID = "id";

}

