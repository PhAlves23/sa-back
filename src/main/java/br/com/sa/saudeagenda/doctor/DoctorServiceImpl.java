package br.com.sa.saudeagenda.doctor;

import br.com.sa.saudeagenda.exception.DatabaseException;
import br.com.sa.saudeagenda.patient.PatientDTO;
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

    @Transactional
    @Override
    public DoctorDTO create(DoctorDTO doctorDTO) {
        log.info("[1] - Mapping doctor.");
        DoctorModel doctorModel = new DoctorModel(doctorDTO);
        log.info("[2] - Saving doctor in the database.");
        repository.save(doctorModel);
        return new DoctorDTO(doctorModel);
    }

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

    @Transactional
    @Override
    public DoctorDTO update(Long idDoctor, DoctorDTO doctorDTO) {
        log.info("[1] - Search doctor in the database. idDoctor: {}", idDoctor);
        DoctorModel doctorModel = repository.findById(idDoctor)
                .orElseThrow(() -> new DatabaseException("Entity not found!"));
        log.info("[2] - Mapping for doctorModel.");
        doctorModel.setName(doctorDTO.getName());
        doctorModel.setEmail(doctorModel.getEmail());
        doctorModel.setTelephone(doctorModel.getTelephone());
        doctorModel.setCrm(doctorModel.getCrm());
        log.info("[3]. Saving new doctor in the database. doctorModel: {}", doctorModel.toString());
        repository.save(doctorModel);
        return new DoctorDTO(doctorModel);
    }

    @Transactional
    @Override
    public void delete(Long idDoctor) {
        log.info("[1] - Delete doctor in the database by id. idDoctor: {}", idDoctor);
        repository.deleteById(idDoctor);
    }

}
