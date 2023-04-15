package br.com.sa.saudeagenda.patient;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "Patient")
@Table(name = "TB_PATIENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PatientModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Email
    private String email;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private String cpf;

    @NotNull
    private String telephone;

    public PatientModel(PatientDTO dto) {
        this.name = dto.getName();
        this.email = dto.getEmail();
        this.birthDate = dto.getBirthDate();
        this.cpf = dto.getCpf();
        this.telephone = dto.getTelephone();
    }
}
