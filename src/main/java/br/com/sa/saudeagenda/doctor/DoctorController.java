package br.com.sa.saudeagenda.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl service;

    @PostMapping
    public ResponseEntity<DoctorDTO> create(@RequestBody DoctorDTO dto){
        DoctorDTO doctorDTO = service.create(dto);
        return ResponseEntity.status(201).body(doctorDTO);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> findAll() {
        List<DoctorDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorDTO> findById(@PathVariable Long id){
        DoctorDTO doctorDTO = service.findById(id);
        return ResponseEntity.ok(doctorDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
