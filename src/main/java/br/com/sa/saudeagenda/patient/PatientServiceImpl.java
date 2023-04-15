package br.com.sa.saudeagenda.patient;


import br.com.sa.saudeagenda.exception.DatabaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository repository;

    @Transactional
    @Override
    public PatientDTO create(PatientDTO patientDTO) {
        log.info("[1] - Mapping patient.");
        var patientModel = new PatientModel(patientDTO);
        log.info("[2] - Saving patient in the database.");
        repository.save(patientModel);
        return new PatientDTO(patientModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<PatientDTO> findAll(){
        log.info("[1] - Search all patients in the database.");
        List<PatientModel> list = repository.findAll();
        return list.stream().map(p -> new PatientDTO(p)).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public PatientDTO findById(Long idPatient) {
        log.info("[1] - Search patient in the database. idPatient: {}", idPatient);
        PatientModel patientModel = repository.findById(idPatient).orElseThrow(() -> new DatabaseException("Entity not found!"));
        return new PatientDTO(patientModel);
    }

    @Transactional
    @Override
    public PatientDTO update(Long idPatient, PatientDTO patientDTO) {
        log.info("[1] - Search patient in the database. idPatient: {}", idPatient);
//        var patientReference = repository.getReferenceById(idPatient);
        var patientReference = repository.findById(idPatient)
                .orElseThrow(() -> new DatabaseException("Entity not found!"));
        log.info("[2] - Mapping for patientModel.");
        patientReference.setName(patientDTO.getName());
        patientReference.setCpf(patientDTO.getCpf());
        patientReference.setBirthDate(patientDTO.getBirthDate());
        patientReference.setTelephone(patientDTO.getTelephone());
        log.info("[3]. Saving new patient in the database. patientModel: {}", patientReference.toString());
        repository.save(patientReference);
        return new PatientDTO(patientReference);
    }

    @Override
    public void delete(Long idPatient) {
        log.info("[1] - Delete patient in the database by id. idPatient: {}", idPatient);
        repository.deleteById(idPatient);
    }
}
