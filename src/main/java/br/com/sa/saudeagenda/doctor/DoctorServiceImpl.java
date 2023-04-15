package br.com.sa.saudeagenda.doctor;

import br.com.sa.saudeagenda.exception.DatabaseException;
import br.com.sa.saudeagenda.patient.PatientDTO;
import br.com.sa.saudeagenda.patient.PatientModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<DoctorDTO> findAll() {
        log.info("[1] - Search all patients in the database.");
        List<DoctorModel> list = repository.findAll();
        return list.stream().map(d -> new DoctorDTO(d)).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public DoctorDTO findById(Long idDoctor) {
        log.info("[1] - Search doctor in the database. idDoctor: {}", idDoctor);
        DoctorModel doctorModel = repository.findById(idDoctor)
                .orElseThrow(() -> new DatabaseException("Entity not found!"));
        return new DoctorDTO(doctorModel);
    }

}
