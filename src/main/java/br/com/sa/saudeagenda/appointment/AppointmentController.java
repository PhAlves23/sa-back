package br.com.sa.saudeagenda.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll(){
        List<AppointmentDTO> appointmentDTO = service.findAll();
        return ResponseEntity.ok(appointmentDTO);
    }

}
