package br.com.sa.saudeagenda.appointment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        log.info("[1] - Mapping appointment.");
        AppointmentModel appointmentModel = new AppointmentModel(appointmentDTO);
        log.info("[2] - Saving appointment in the database.");
        repository.save(appointmentModel);
        return new AppointmentDTO(appointmentModel);
    }

    @Override
    public List<AppointmentDTO> findAll() {
        log.info("[1] - Search all appointments in the database.");
        List<AppointmentModel> list = repository.findAll();
        return list.stream().map(a -> new AppointmentDTO(a)).toList();
    }

}
