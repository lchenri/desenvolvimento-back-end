package br.com.multicinema.cinemaapi.utils.validation.celular;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CelularValidator implements ConstraintValidator<ValidCelular, String> {

    @Override
    public boolean isValid(String celular, ConstraintValidatorContext context) {
        return celular != null && celular.matches("\\d{2}9\\d{8}");
    }
}
