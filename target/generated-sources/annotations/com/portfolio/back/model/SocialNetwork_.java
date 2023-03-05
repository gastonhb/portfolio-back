package com.portfolio.back.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SocialNetwork.class)
public abstract class SocialNetwork_ {

	public static volatile SingularAttribute<SocialNetwork, Person> person;
	public static volatile SingularAttribute<SocialNetwork, UUID> id;
	public static volatile SingularAttribute<SocialNetwork, String> content;
	public static volatile SingularAttribute<SocialNetwork, SocialNetworkType> socialNetworkType;

	public static final String PERSON = "person";
	public static final String ID = "id";
	public static final String CONTENT = "content";
	public static final String SOCIAL_NETWORK_TYPE = "socialNetworkType";

}

