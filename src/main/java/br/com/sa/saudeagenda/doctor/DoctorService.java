package br.com.sa.saudeagenda.doctor;

import br.com.sa.saudeagenda.patient.PatientDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface DoctorService {


    /**
     * <h2>Method responsible for saving a new <b><i>Doctor</i></b>.</h2>
     *
     * @param doctorDTO the doctor dto
     * @return {@link DoctorDTO}
     */
    DoctorDTO create(DoctorDTO doctorDTO);


    /**
     * <h2>
     * Method responsible for retrieving all <b><i>doctors</i></b>.
     * </h2>
     *
     * @return {@link DoctorDTO}
     */
    List<DoctorDTO> findAll();


    /**
     * <h2>
     * Method responsible for retrieving doctor by <b><i>idDoctor</i></b>.
     * </h2>
     *
     * @param idDoctor the id category.
     * @return {@link DoctorDTO}
     */
    DoctorDTO findById(Long idDoctor);


    /**
     * <h2>
     * Method responsible for updateting  <b><i>Doctor</i></b>.
     * </h2>
     *
     * @param idDoctor
     * @param doctorDTO
     * @return {@link DoctorDTO}
     */
    DoctorDTO update(Long idDoctor, DoctorDTO doctorDTO);

    /**
     * <h2>
     * Method responsible for deleting  <b><i>doctors</i></b>.
     * </h2>
     *
     * @param idDoctor
     */
    void delete(Long idDoctor);
}
