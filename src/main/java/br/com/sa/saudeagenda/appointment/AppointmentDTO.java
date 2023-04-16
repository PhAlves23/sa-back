package br.com.sa.saudeagenda.appointment;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AppointmentDTO {

    private Long id;

    private LocalDate date;

    private LocalDateTime appointmentTime;

    public AppointmentDTO(AppointmentModel a) {
        this.id = a.getId();
        this.date = a.getDate();
        this.appointmentTime = a.getAppointmentTime();
    }
}
