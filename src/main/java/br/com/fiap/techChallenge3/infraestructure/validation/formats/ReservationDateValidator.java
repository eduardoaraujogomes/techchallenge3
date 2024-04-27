package br.com.fiap.techChallenge3.infraestructure.validation.formats;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ReservationDateValidator implements ConstraintValidator<ReservationDate, String> {

  @Override
  public boolean isValid(String fieldValue, ConstraintValidatorContext context) {
    if (fieldValue == null || fieldValue.isBlank())
      return true; // We ignore whether the field is null in update requests

    try {
      LocalDate date = LocalDate.parse(fieldValue, ReservationDate.formatter);
      return date.isEqual(LocalDate.now()) || date.isAfter(LocalDate.now());
    } catch (Exception e) {
      return false;
    }
  }
}
