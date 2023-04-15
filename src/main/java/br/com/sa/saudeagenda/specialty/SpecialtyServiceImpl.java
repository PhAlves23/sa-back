package br.com.sa.saudeagenda.specialty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository repository;

    @Transactional
    @Override
    public SpecialtyDTO create(SpecialtyDTO specialtyDTO) {
        log.info("[1] - Mapping specialty.");
        SpecialtyModel  specialtyModel  = new SpecialtyModel(specialtyDTO);
        log.info("[2] - Saving specialty in the database.");
        repository.save(specialtyModel);
        return new SpecialtyDTO(specialtyModel);

    }

    @Transactional(readOnly = true)
    @Override
    public List<SpecialtyDTO> findAll() {
        List<SpecialtyModel> list = repository.findAll();
        return list.stream().map(s -> new SpecialtyDTO(s)).toList();
    }

    @Transactional
    @Override
    public SpecialtyDTO findById(Long idSpecialty) {
        return null;
    }
}
