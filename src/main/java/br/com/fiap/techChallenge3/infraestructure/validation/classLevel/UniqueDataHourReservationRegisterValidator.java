package br.com.fiap.techChallenge3.infraestructure.validation.classLevel;

import br.com.fiap.techChallenge3.infraestructure.config.db.repository.CustomerRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.repository.ReservationRepository;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.CustomerSchema;
import br.com.fiap.techChallenge3.infraestructure.config.db.schema.ReservationSchema;
import br.com.fiap.techChallenge3.infraestructure.reservation.dto.ReservationRegistrationData;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class UniqueDataHourReservationRegisterValidator implements ConstraintValidator<ValidReservationRegistrationData, ReservationRegistrationData> {

    @Autowired
    private ReservationRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean isValid(ReservationRegistrationData reservation, ConstraintValidatorContext context) {

        if (repository != null) {
            AtomicBoolean isValid = new AtomicBoolean(true);
            List<ReservationSchema> reservations = repository.findAllByCustomerId(reservation.customerId());

            if (reservations == null) {
                return true;
            }

            reservations.forEach(reservation1 -> {
                System.out.println("reservation1.getDate(): " + reservation1.getDate());
                if (reservation1.getDate().equals(LocalDate.parse(reservation.date(), DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                        && reservation1.getHour().equals(LocalTime.parse(reservation.hour(), DateTimeFormatter.ofPattern("HH:00")))) {
                    isValid.set(false);
                }
            });

            if (!isValid.get()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                        .addPropertyNode("hour").addConstraintViolation();
            }

            return isValid.get();
        } else {
            return true;
        }
    }
}
