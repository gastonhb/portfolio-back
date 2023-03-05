package com.portfolio.back.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ {

	public static volatile SingularAttribute<Person, String> urlCoverPhoto;
	public static volatile SingularAttribute<Person, String> abstracts;
	public static volatile SingularAttribute<Person, String> name;
	public static volatile SingularAttribute<Person, UUID> id;
	public static volatile SingularAttribute<Person, String> title;
	public static volatile SingularAttribute<Person, String> lastname;
	public static volatile SingularAttribute<Person, String> urlImage;

	public static final String URL_COVER_PHOTO = "urlCoverPhoto";
	public static final String ABSTRACTS = "abstracts";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String LASTNAME = "lastname";
	public static final String URL_IMAGE = "urlImage";

}

