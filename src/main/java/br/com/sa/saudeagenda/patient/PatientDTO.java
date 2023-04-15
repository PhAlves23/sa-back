package br.com.sa.saudeagenda.patient;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PatientDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String cpf;
    private String telephone;

    public PatientDTO(PatientModel p) {
        this.id = p.getId();
        this.name = p.getName();
        this.email = p.getEmail();
        this.birthDate = p.getBirthDate();
        this.cpf = p.getCpf();
        this.telephone = p.getTelephone();
    }
}
