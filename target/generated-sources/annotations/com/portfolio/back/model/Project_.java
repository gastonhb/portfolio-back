package com.portfolio.back.model;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Project.class)
public abstract class Project_ {

	public static volatile SingularAttribute<Project, Date> endDate;
	public static volatile SingularAttribute<Project, Person> person;
	public static volatile SingularAttribute<Project, String> name;
	public static volatile SingularAttribute<Project, String> link;
	public static volatile SingularAttribute<Project, String> description;
	public static volatile SingularAttribute<Project, UUID> id;
	public static volatile SingularAttribute<Project, Date> startDate;
	public static volatile SingularAttribute<Project, String> urlImage;

	public static final String END_DATE = "endDate";
	public static final String PERSON = "person";
	public static final String NAME = "name";
	public static final String LINK = "link";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String START_DATE = "startDate";
	public static final String URL_IMAGE = "urlImage";

}

