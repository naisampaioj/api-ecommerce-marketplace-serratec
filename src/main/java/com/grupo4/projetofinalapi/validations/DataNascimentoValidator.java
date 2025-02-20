package com.grupo4.projetofinalapi.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class DataNascimentoValidator implements ConstraintValidator<ValidDataNascimento, LocalDate>{

	@Override
	public boolean isValid(LocalDate dataRecebida, ConstraintValidatorContext context) {
		LocalDate hoje = LocalDate.now();
		
		Period diferencaEntreDatas = Period.between(dataRecebida, hoje);
		return ((diferencaEntreDatas.getYears() >= 18) && (diferencaEntreDatas.getYears() <=120) && (!diferencaEntreDatas.isNegative()));
	}
}
