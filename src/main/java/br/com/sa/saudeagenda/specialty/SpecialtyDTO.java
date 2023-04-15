package br.com.sa.saudeagenda.specialty;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SpecialtyDTO {

    private Long id;

    private String name;

    private String description;


    public SpecialtyDTO(SpecialtyModel s) {
        this.id = s.getId();
        this.name = s.getName();
        this.description = s.getDescription();
    }
}
