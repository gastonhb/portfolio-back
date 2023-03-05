package com.portfolio.back.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SocialNetworkType.class)
public abstract class SocialNetworkType_ {

	public static volatile SingularAttribute<SocialNetworkType, Boolean> isLink;
	public static volatile SingularAttribute<SocialNetworkType, String> name;
	public static volatile SingularAttribute<SocialNetworkType, UUID> id;

	public static final String IS_LINK = "isLink";
	public static final String NAME = "name";
	public static final String ID = "id";

}

