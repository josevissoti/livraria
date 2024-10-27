package com.curso.services;

import com.curso.domains.Autor;
import com.curso.domains.dtos.AutorDTO;
import com.curso.repositories.AutorRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepo;

    public List<AutorDTO> findAll(){
        return autorRepo.findAll().stream()
                .map(obj -> new AutorDTO(obj))
                .collect(Collectors.toList());
    }

    public Autor findbyId(int id){
        Optional<Autor> obj = autorRepo.findById(id);
        return obj.orElse(null);
    }

    public Autor create(AutorDTO dto){
        dto.setId(null);
        Autor obj = new Autor(dto);
        return autorRepo.save(obj);
    }

    public Autor update(Integer id, AutorDTO objDto){
        objDto.setId(id);
        Autor oldObj = findbyId(id);
        oldObj = new Autor(objDto);
        return autorRepo.save(oldObj);
    }

    public void delete(Integer id){
        Autor obj = findbyId(id);
        if (obj.getLivros().size()>0){
            throw new DataIntegrityViolationException("Autor não pode ser deletado pos possuí livros vinculádos.");
        }
        autorRepo.deleteById(id);
    }

}
