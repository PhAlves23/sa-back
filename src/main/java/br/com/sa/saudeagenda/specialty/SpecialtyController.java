package br.com.sa.saudeagenda.specialty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidades")
public class SpecialtyController {

    @Autowired
    private SpecialtyService service;

    @GetMapping
    public ResponseEntity<List<SpecialtyDTO>> findAll(){
        List<SpecialtyDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<SpecialtyDTO> findById(@PathVariable Long id){
        SpecialtyDTO specialtyDTO = service.findById(id);
        return ResponseEntity.ok(specialtyDTO);
    }

    @PostMapping
    public ResponseEntity<SpecialtyDTO> create(@RequestBody SpecialtyDTO dto){
        SpecialtyDTO specialtyDTO = service.create(dto);
        return ResponseEntity.status(201).body(specialtyDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
