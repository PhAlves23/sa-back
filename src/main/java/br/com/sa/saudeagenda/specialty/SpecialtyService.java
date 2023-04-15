package br.com.sa.saudeagenda.specialty;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SpecialtyService {

    /**
     * <h2>
     * Method responsible for retrieving all <b><i>specialties</i></b>.
     * </h2>
     *
     * @return {@link SpecialtyDTO}
     */
    List<SpecialtyDTO> findAll();
}
