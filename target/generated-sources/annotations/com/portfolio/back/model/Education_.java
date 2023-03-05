package com.portfolio.back.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Education.class)
public abstract class Education_ {

	public static volatile SingularAttribute<Education, Number> endDate;
	public static volatile SingularAttribute<Education, Person> person;
	public static volatile SingularAttribute<Education, String> institute;
	public static volatile SingularAttribute<Education, UUID> id;
	public static volatile SingularAttribute<Education, String> title;
	public static volatile SingularAttribute<Education, Number> startDate;
	public static volatile SingularAttribute<Education, String> urlImage;

	public static final String END_DATE = "endDate";
	public static final String PERSON = "person";
	public static final String INSTITUTE = "institute";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String START_DATE = "startDate";
	public static final String URL_IMAGE = "urlImage";

}

