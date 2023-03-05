package com.portfolio.back.model;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Skill.class)
public abstract class Skill_ {

	public static volatile SingularAttribute<Skill, SkillType> skillType;
	public static volatile SingularAttribute<Skill, Person> person;
	public static volatile SingularAttribute<Skill, Integer> grade;
	public static volatile SingularAttribute<Skill, String> name;
	public static volatile SingularAttribute<Skill, UUID> id;

	public static final String SKILL_TYPE = "skillType";
	public static final String PERSON = "person";
	public static final String GRADE = "grade";
	public static final String NAME = "name";
	public static final String ID = "id";

}

