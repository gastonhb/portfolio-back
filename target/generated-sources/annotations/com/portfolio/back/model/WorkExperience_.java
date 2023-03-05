package com.portfolio.back.model;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WorkExperience.class)
public abstract class WorkExperience_ {

	public static volatile SingularAttribute<WorkExperience, Date> endDate;
	public static volatile SingularAttribute<WorkExperience, Person> person;
	public static volatile SingularAttribute<WorkExperience, String> companyName;
	public static volatile SingularAttribute<WorkExperience, String> location;
	public static volatile SingularAttribute<WorkExperience, UUID> id;
	public static volatile SingularAttribute<WorkExperience, String> title;
	public static volatile SingularAttribute<WorkExperience, WorkTimeType> workTimeType;
	public static volatile SingularAttribute<WorkExperience, Date> startDate;
	public static volatile SingularAttribute<WorkExperience, String> urlImage;

	public static final String END_DATE = "endDate";
	public static final String PERSON = "person";
	public static final String COMPANY_NAME = "companyName";
	public static final String LOCATION = "location";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String WORK_TIME_TYPE = "workTimeType";
	public static final String START_DATE = "startDate";
	public static final String URL_IMAGE = "urlImage";

}

