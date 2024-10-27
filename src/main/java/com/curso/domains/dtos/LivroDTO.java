package com.curso.domains.dtos;

import com.curso.domains.Livro;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDTO {

    private Long idLivro;

    @NotNull(message = "O campo título não pode ser nulo")
    @NotBlank(message = "O campo título não pode estar vazio")
    private String titulo;

    @NotNull(message = "O campo ISBN não pode ser nulo")
    private String isbn;

    @NotNull(message = "O campo número de páginas não pode ser nulo")
    private int numeroPaginas;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCompra = LocalDate.now();

    @NotNull(message = "O campo valor de compra não pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal valorCompra;

    @NotNull(message = "O campo autor é requerido")
    private int idAutor;
    private String nome;
    private String documentoPessoal;

    @NotNull(message = "O campo editora é requerido")
    private int idEditora;
    private String cnpj;
    private String razaoSocial;

    private int status;
    private int conservacao;

    public LivroDTO() {
    }

    public LivroDTO(Livro livro) {
        this.idLivro = livro.getIdLivro();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.numeroPaginas = livro.getNumeroPaginas();
        this.dataCompra = livro.getDataCompra();
        this.valorCompra = livro.getValorCompra();
        this.idAutor = livro.getAutor().getId();
        this.nome = livro.getAutor().getNome();
        this.documentoPessoal = livro.getAutor().getDocumentoPessoal();
        this.idEditora = livro.getEditora().getId();
        this.cnpj = livro.getEditora().getCnpj();
        this.razaoSocial = livro.getEditora().getRazaoSocial();
        this.status = livro.getStatus().getId();
        this.conservacao = livro.getConservacao().getId();
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public @NotNull(message = "O campo título não pode ser nulo") @NotBlank(message = "O campo título não pode estar vazio") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotNull(message = "O campo título não pode ser nulo") @NotBlank(message = "O campo título não pode estar vazio") String titulo) {
        this.titulo = titulo;
    }

    public @NotNull(message = "O campo ISBN não pode ser nulo") String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotNull(message = "O campo ISBN não pode ser nulo") String isbn) {
        this.isbn = isbn;
    }

    @NotNull(message = "O campo número de páginas não pode ser nulo")
    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(@NotNull(message = "O campo número de páginas não pode ser nulo") int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public @NotNull(message = "O campo valor de compra não pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(@NotNull(message = "O campo valor de compra não pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    @NotNull(message = "O campo autor é requerido")
    public int getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(@NotNull(message = "O campo autor é requerido") int idAutor) {
        this.idAutor = idAutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumentoPessoal() {
        return documentoPessoal;
    }

    public void setDocumentoPessoal(String documentoPessoal) {
        this.documentoPessoal = documentoPessoal;
    }

    @NotNull(message = "O campo editora é requerido")
    public int getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(@NotNull(message = "O campo editora é requerido") int idEditora) {
        this.idEditora = idEditora;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getConservacao() {
        return conservacao;
    }

    public void setConservacao(int conservacao) {
        this.conservacao = conservacao;
    }
}
