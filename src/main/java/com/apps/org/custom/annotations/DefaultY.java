package com.apps.org.custom.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DefaultY {
	
	public String key() default "M";
	
	static final String defaultY = "Y";

	public String value() default "X";

}
