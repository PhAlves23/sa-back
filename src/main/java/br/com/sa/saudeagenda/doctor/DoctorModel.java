package br.com.sa.saudeagenda.doctor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity(name = "Doctor")
@Table(name = "TB_DOCTOR")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DoctorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @Email
    private String email;

    @NotNull
    private String telephone;

    @NotNull
    private String crm;

    //N X M
    //    private String specialty;

    //    @ManyToOne(fetch = FetchType.LAZY)
    //    private Endereco endereco;

    //    @ManyToOne(fetch = FetchType.LAZY)
    //    private Convenio convenio;

    public DoctorModel(DoctorDTO doctorDTO) {
        this.name = doctorDTO.getName();
        this.email = doctorDTO.getEmail();
        this.telephone = doctorDTO.getTelephone();
        this.crm = doctorDTO.getCrm();
    }

}
