package br.com.sa.saudeagenda.appointment;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Appointment")
@Table(name = "TB_APPOINTMENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AppointmentModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalDateTime appointmentTime;

    public AppointmentModel(AppointmentDTO a) {
        this.date = a.getDate();
        this.appointmentTime = a.getAppointmentTime();
    }
}
