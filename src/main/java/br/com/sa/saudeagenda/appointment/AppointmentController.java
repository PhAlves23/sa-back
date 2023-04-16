package br.com.sa.saudeagenda.appointment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping
    public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentDTO dto){
        AppointmentDTO appointmentDTO = service.create(dto);
        return ResponseEntity.status(201).body(appointmentDTO);
    }

    @GetMapping
    public ResponseEntity<List<AppointmentDTO>> findAll(){
        List<AppointmentDTO> appointmentDTO = service.findAll();
        return ResponseEntity.ok(appointmentDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity<AppointmentDTO> findById(@PathVariable Long id){
        AppointmentDTO appointmentDTO = service.findById(id);
        return ResponseEntity.ok(appointmentDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
