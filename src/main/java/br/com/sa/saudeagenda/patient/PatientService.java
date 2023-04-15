package br.com.sa.saudeagenda.patient;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientService {

    /**
     * <h2>
     * Method responsible for retrieving all <b><i>categories</i></b>.
     * </h2>
     *
     * @return {@link PatientDTO}
     */
    List<PatientDTO> findAll();
}
