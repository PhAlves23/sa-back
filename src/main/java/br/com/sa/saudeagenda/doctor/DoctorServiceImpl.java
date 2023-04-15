package br.com.sa.saudeagenda.doctor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repository;


    @Override
    public List<DoctorDTO> findAll() {
        log.info("[1] - Search all patients in the database.");
        List<DoctorModel> list = repository.findAll();
        return list.stream().map(d -> new DoctorDTO(d)).toList();
    }
}
