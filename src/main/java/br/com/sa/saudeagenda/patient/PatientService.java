package br.com.sa.saudeagenda.patient;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientService {

    /**
     * <h2>Method responsible for saving a new <b><i>Category</i></b>.</h2>
     *
     * @param PatientDTO the category dto
     * @return {@link PatientDTO}
     */
    public PatientDTO create(PatientDTO dto);


    /**
     * <h2>
     * Method responsible for retrieving all <b><i>categories</i></b>.
     * </h2>
     *
     * @return {@link PatientDTO}
     */
    List<PatientDTO> findAll();
}
