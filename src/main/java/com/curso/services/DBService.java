package com.curso.services;

import com.curso.domains.Autor;
import com.curso.domains.Editora;
import com.curso.domains.Livro;
import com.curso.domains.enums.Conservacao;
import com.curso.domains.enums.Status;
import com.curso.repositories.AutorRepository;
import com.curso.repositories.EditoraRepository;
import com.curso.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {

    @Autowired
    private AutorRepository autorRepo;

    @Autowired
    private EditoraRepository editoraRepo;

    @Autowired
    private LivroRepository livroRepo;

    public void initDB(){

        Editora editora01 = new Editora(null, "562938", "Saraiva");
        Editora editora02 = new Editora(null, "752902", "Bom Jesus");

        Autor autor01 = new Autor(null, "Machado de Assis", "725398275");
        Autor autor02 = new Autor(null, "Eiichiro Oda", "62962302370");

        Livro livro01 = new Livro(null, "Memórias Póstumas de Brás Cubas", "4792347927",
                42, LocalDate.now(), new BigDecimal("325.90"), autor01, editora02,
                Status.LENDO, Conservacao.BOM);
        Livro livro02 = new Livro(null, "One Piece", "5729752352", 2052, LocalDate.now(),
                new BigDecimal("293.80"), autor02, editora01, Status.LIDO, Conservacao.EXCELENTE);

        autorRepo.save(autor01);
        autorRepo.save(autor02);
        editoraRepo.save(editora01);
        editoraRepo.save(editora02);
        livroRepo.save(livro01);
        livroRepo.save(livro02);

    }
}
