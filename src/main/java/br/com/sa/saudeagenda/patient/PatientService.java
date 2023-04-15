package br.com.sa.saudeagenda.patient;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PatientService {

    /**
     * <h2>Method responsible for saving a new <b><i>Category</i></b>.</h2>
     *
     * @param patientDTO the category dto
     * @return {@link PatientDTO}
     */
    PatientDTO create(PatientDTO patientDTO);


    /**
     * <h2>
     * Method responsible for retrieving all <b><i>patients</i></b>.
     * </h2>
     *
     * @return {@link PatientDTO}
     */
     List<PatientDTO> findAll();

    /**
     * <h2>
     * Method responsible for retrieving patient by <b><i>idPatient</i></b>.
     * </h2>
     *
     * @param idPatient the id category.
     * @return {@link PatientDTO}
     */
    PatientDTO findById(Long idPatient);


    /**
     * <h2>
     * Method responsible for updateting  <b><i>Patient</i></b>.
     * </h2>
     *
     * @param idPatient
     * @param patientDTO
     * @return {@link PatientDTO}
     */
    PatientDTO update(Long idPatient, PatientDTO patientDTO);
}
