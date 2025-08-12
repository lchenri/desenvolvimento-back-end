package br.com.multicinema.cinemaapi.utils.validation.celular;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CelularValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidCelular {
    String message() default "Número de celular inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}