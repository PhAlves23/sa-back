package br.com.sa.saudeagenda.doctor;

import br.com.sa.saudeagenda.patient.PatientDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public interface DoctorService {

    /**
     * <h2>
     * Method responsible for retrieving all <b><i>doctors</i></b>.
     * </h2>
     *
     * @return {@link DoctorDTO}
     */
    List<DoctorDTO> findAll();
}
