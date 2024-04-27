package br.com.fiap.techChallenge3.infraestructure.validation.classLevel;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueDataHourReservationRegisterValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidReservationRegistrationData {
  String message() default "There is already a reservation registered for that customer on that date and time";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
