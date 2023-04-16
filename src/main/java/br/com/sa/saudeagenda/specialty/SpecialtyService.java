package br.com.sa.saudeagenda.specialty;

import br.com.sa.saudeagenda.patient.PatientDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SpecialtyService {

    /**
     * <h2>Method responsible for saving a new <b><i>Specialty</i></b>.</h2>
     *
     * @param specialtyDTO the specialty dto
     * @return {@link SpecialtyDTO}
     */
    SpecialtyDTO create(SpecialtyDTO specialtyDTO);

    /**
     * <h2>
     * Method responsible for retrieving all <b><i>specialties</i></b>.
     * </h2>
     *
     * @return {@link SpecialtyDTO}
     */
    List<SpecialtyDTO> findAll();

    /**
     * <h2>
     * Method responsible for retrieving patient by <b><i>idPatient</i></b>.
     * </h2>
     *
     * @param idSpecialty the id category.
     * @return {@link SpecialtyDTO}
     */
    SpecialtyDTO findById(Long idSpecialty);

    /**
     * <h2>
     * Method responsible for updateting  <b><i>Specialty</i></b>.
     * </h2>
     *
     * @param idSpecialty
     * @param specialtyDTO
     * @return {@link SpecialtyDTO}
     */
    SpecialtyDTO update(Long idSpecialty, SpecialtyDTO specialtyDTO);


    /**
     * <h2>
     * Method responsible for deleting  <b><i>specialties</i></b>.
     * </h2>
     *
     * @param idSpecialty
     */
    void delete(Long idSpecialty);
}
