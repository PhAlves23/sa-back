package br.com.sa.saudeagenda.patient;


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

    @Override
    @Transactional(readOnly = true)

    public List<PatientDTO> findAll(){
        log.info("[1] - Search all patients in the database.");
        List<PatientModel> list = repository.findAll();
        return list.stream().map(p -> new PatientDTO(p)).toList();
    }
}
