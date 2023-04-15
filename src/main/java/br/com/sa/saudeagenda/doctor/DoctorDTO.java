package br.com.sa.saudeagenda.doctor;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DoctorDTO {

    private Long id;

    private String name;

    private String email;

    private String telephone;

    private String crm;

    public DoctorDTO(DoctorModel d) {
        this.id = d.getId();
        this.name = d.getName();
        this.email = d.getEmail();
        this.telephone = d.getTelephone();
        this.crm = d.getCrm();
    }
}
