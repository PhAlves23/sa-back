package br.com.sa.saudeagenda.specialty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpecialtyServiceImpl implements SpecialtyService {

    @Autowired
    private SpecialtyRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<SpecialtyDTO> findAll() {
        List<SpecialtyModel> list = repository.findAll();
        return list.stream().map(s -> new SpecialtyDTO(s)).toList();
    }
}
