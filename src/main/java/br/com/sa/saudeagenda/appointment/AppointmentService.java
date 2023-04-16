package br.com.sa.saudeagenda.appointment;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AppointmentService {

    /**
     * <h2>Method responsible for saving a new <b><i>Appointment</i></b>.</h2>
     *
     * @param appointmentDTO the patient dto
     * @return {@link AppointmentDTO}
     */
    AppointmentDTO create(AppointmentDTO appointmentDTO);


    /**
     * <h2>
     * Method responsible for retrieving all <b><i>appointments</i></b>.
     * </h2>
     *
     * @return {@link AppointmentDTO}
     */
    List<AppointmentDTO> findAll();

    /**
     * <h2>
     * Method responsible for retrieving appointment by <b><i>idAppointment</i></b>.
     * </h2>
     *
     * @param idAppointment the id category.
     * @return {@link AppointmentDTO}
     */
    AppointmentDTO findById(Long idAppointment);


//    /**
//     * <h2>
//     * Method responsible for updateting  <b><i>Appointment</i></b>.
//     * </h2>
//     *
//     * @param idAppointment
//     * @param appointmentDTO
//     * @return {@link AppointmentDTO}
//     */
//    AppointmentDTO update(Long idAppointment, AppointmentDTO appointmentDTO);

//    /**
//     * <h2>
//     * Method responsible for deleting  <b><i>appointments</i></b>.
//     * </h2>
//     *
//     * @param idAppointment
//     */
//    void delete(Long idAppointment);

}
