package DIO.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import DIO.springboot.model.Curso;
import DIO.springboot.repository.CursoRepository;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoRepository CursoR;
    @PostMapping
    public Curso Cadastrar(@RequestBody Curso curso){
        return CursoR.save(curso);
    }
}
