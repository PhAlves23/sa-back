package br.com.sa.saudeagenda.doctor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
public class DoctorController {

    @Autowired
    private DoctorServiceImpl service;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> findAll() {
        List<DoctorDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }
}
