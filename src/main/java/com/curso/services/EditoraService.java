package com.curso.services;

import com.curso.domains.Editora;
import com.curso.domains.dtos.EditoraDTO;
import com.curso.repositories.EditoraRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EditoraService {

    @Autowired
    private EditoraRepository editoraRepo;

    public List<EditoraDTO> findAll(){
        return editoraRepo.findAll().stream()
                .map(obj -> new EditoraDTO(obj))
                .collect(Collectors.toList());
    }

    public Editora findbyId(int id) {
        Optional<Editora> obj = editoraRepo.findById(id);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Editora não encontrada. ID: " +id)
        );
    }

    public Editora findbyCnpj(String cnpj){
        Optional<Editora> obj = editoraRepo.findByCnpj(cnpj);
        return obj.orElseThrow(
                () -> new ObjectNotFoundException("Editora não encontrada. CNPJ: " +cnpj)
        );
    }

    public Editora create(EditoraDTO dto){
        dto.setId(null);
        validaEditora(dto);
        Editora obj = new Editora(dto);
        return editoraRepo.save(obj);
    }

    private void validaEditora(EditoraDTO dto){
        Optional<Editora> obj = editoraRepo.findByCnpj(dto.getCnpj());
        if(obj.isPresent() && obj.get().getId() != dto.getId()){
            throw new DataIntegrityViolationException("CNPJ já cadastrado");
        }
    }

    public Editora update(Integer id, EditoraDTO objDto){
        objDto.setId(id);
        Editora oldObj = findbyId(id);
        validaEditora(objDto);
        oldObj = new Editora(objDto);
        return editoraRepo.save(oldObj);
    }

    public void delete(Integer id){
        Editora obj = findbyId(id);
        if(obj.getLivros().size()>0){
            throw new DataIntegrityViolationException("Editora não pode ser deletada pois possuí livros vinculádos.");
        }
        editoraRepo.deleteById(id);
    }

}
