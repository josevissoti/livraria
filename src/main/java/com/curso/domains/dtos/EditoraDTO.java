package com.curso.domains.dtos;

import com.curso.domains.Editora;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EditoraDTO {

    private Integer id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String cnpj;
    private String razaoSocial;

    public EditoraDTO() {
    }

    public EditoraDTO(Editora editora) {
        this.id = editora.getId();
        this.cnpj = editora.getCnpj();
        this.razaoSocial = editora.getRazaoSocial();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }
}
