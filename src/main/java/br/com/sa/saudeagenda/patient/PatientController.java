package br.com.sa.saudeagenda.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PatientController {

    @Autowired
    private PatientServiceImpl service;

    @GetMapping
    public ResponseEntity<List<PatientDTO>> findAll(){
        List<PatientDTO> patients = service.findAll();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable Long id){
        PatientDTO patient = service.findById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public ResponseEntity<PatientDTO> create(@RequestBody PatientDTO dto){
        PatientDTO patientDTO = service.create(dto);
        return ResponseEntity.status(201).body(patientDTO);
    }

    @PutMapping("{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable Long id, @RequestBody PatientDTO dto){
        PatientDTO patientDTO = service.update(id, dto);
        return ResponseEntity.ok(patientDTO);
    }

}
