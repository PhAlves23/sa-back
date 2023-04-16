package br.com.sa.saudeagenda.appointment;

import br.com.sa.saudeagenda.exception.DatabaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Transactional
    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {
        log.info("[1] - Mapping appointment.");
        AppointmentModel appointmentModel = new AppointmentModel(appointmentDTO);
        log.info("[2] - Saving appointment in the database.");
        repository.save(appointmentModel);
        return new AppointmentDTO(appointmentModel);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AppointmentDTO> findAll() {
        log.info("[1] - Search all appointments in the database.");
        List<AppointmentModel> list = repository.findAll();
        return list.stream().map(a -> new AppointmentDTO(a)).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public AppointmentDTO findById(Long idAppointment) {
        log.info("[1] - Search appointment in the database. idAppointment: {}", idAppointment);
        AppointmentModel appointmentModel = repository.findById(idAppointment)
                .orElseThrow(() -> new DatabaseException("Entity not found!"));
        return new AppointmentDTO(appointmentModel);
    }

    @Override
    public void delete(Long idAppointment) {
        log.info("[1] - Delete appointment in the database by id. idAppointment: {}", idAppointment);
        repository.deleteById(idAppointment);
    }

}
