package masterSpringMvc.config;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = Myannotaion.MyannotaionImpl.class)

public @interface Myannotaion {

	String message() default "Empty field found";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	class MyannotaionImpl implements ConstraintValidator<Myannotaion, List<String>> {
		
		public void initialize(Myannotaion myannotaion) {

		}

		@Override
		public boolean isValid(List<String> value, ConstraintValidatorContext context) {
			if (value.contains("")) {
				return false;
			}
			return true;
		}}

}
