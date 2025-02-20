package com.grupo4.projetofinalapi.dto;

import com.grupo4.projetofinalapi.entities.Endereco;
import com.grupo4.projetofinalapi.entities.Usuario;
import com.grupo4.projetofinalapi.enums.Sexo;
import com.grupo4.projetofinalapi.groups.GruposValidacao;
import com.grupo4.projetofinalapi.validations.ValidDataNascimento;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

public class UsuarioDTO {

	private Long id;

	@NotBlank(message = "Nome não pode ficar em branco ou nulo", groups = {GruposValidacao.ValidadorPost.class})
	private String nome;

	@NotBlank(message = "Sobrenome não pode ficar em branco ou nulo", groups = {GruposValidacao.ValidadorPost.class})
	private String sobrenome;

	@NotNull(message = "Sexo não pode ser nulo", groups = {GruposValidacao.ValidadorPost.class})
	private Sexo sexo;

	@NotBlank(message = "Telefone principal não pode ficar em branco ou nulo", groups = {GruposValidacao.ValidadorPost.class})
	private String telefonePrincipal;

	private String telefoneSecundario;

	@NotBlank(message = "Nome de usuário não pode ficar em branco ou nulo", groups = {GruposValidacao.ValidadorPost.class})
	private String nomeUsuario;

	@NotBlank(message = "Senha não pode ficar em branco ou nulo", groups = {GruposValidacao.ValidadorPost.class})
	private String senhaUsuario;

	@NotBlank(message = "E-mail não pode ficar em branco ou nulo", groups = {GruposValidacao.ValidadorPost.class})
	@Email(message = "E-mail inválido", groups = {GruposValidacao.ValidadorPost.class, GruposValidacao.ValidadorPut.class})
	private String email;

	@NotBlank(message = "CPF não pode ficar em branco ou nulo", groups = {GruposValidacao.ValidadorPost.class})
	@CPF(message = "CPF inválido", groups = {GruposValidacao.ValidadorPost.class, GruposValidacao.ValidadorPut.class})
	private String cpf;

	@NotNull(message = "Data de nascimento não pode ser nula", groups = {GruposValidacao.ValidadorPost.class})
	@ValidDataNascimento(message = "Usuário deve ser possuir mais de 18 anos ou menos de 120", groups = {GruposValidacao.ValidadorPost.class, GruposValidacao.ValidadorPut.class})
	@Past(message = "Data de nascimento deve ser anterior a hoje", groups = {GruposValidacao.ValidadorPost.class, GruposValidacao.ValidadorPut.class})
	// TODO Verificar formatação da data
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	
	private boolean ehVendedor;

	@NotNull(message = "Endereço não pode ser nulo", groups = {GruposValidacao.ValidadorPost.class})
	private Endereco endereco;

	public UsuarioDTO(Long id,
					  String nome,
					  String sobrenome,
					  Sexo sexo,
					  String telefonePrincipal,
					  String telefoneSecundario,
					  String nomeUsuario,
					  String senhaUsuario,
					  String email,
					  String cpf,
					  LocalDate dataNascimento,
					  boolean ehVendedor,
					  Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.sexo = sexo;
		this.telefonePrincipal = telefonePrincipal;
		this.telefoneSecundario = telefoneSecundario;
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.ehVendedor = ehVendedor;
		this.endereco = endereco;
	}

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.sexo = usuario.getSexo();
		this.telefonePrincipal = usuario.getTelefonePrincipal();
		this.telefoneSecundario = usuario.getTelefoneSecundario();
		this.nomeUsuario = usuario.getNomeUsuario();
		this.senhaUsuario = usuario.getSenhaUsuario();
		this.email = usuario.getEmail();
		this.cpf = usuario.getCpf();
		this.dataNascimento = usuario.getDataNascimento();
		this.ehVendedor = usuario.isEhVendedor();
		this.endereco = usuario.getEndereco();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(String telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public String getTelefoneSecundario() {
		return telefoneSecundario;
	}

	public void setTelefoneSecundario(String telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public boolean isEhVendedor() {
		return ehVendedor;
	}

	public void setEhVendedor(boolean ehVendedor) {
		this.ehVendedor = ehVendedor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario converterParaUsuario() {
		return new Usuario(this.nome,
				this.sobrenome,
				this.sexo, 
				this.telefonePrincipal,
				this.telefoneSecundario,
				this.nomeUsuario,
				this.senhaUsuario,
				this.email,
				this.cpf,
				this.dataNascimento, 
				this.ehVendedor,
				this.endereco);
	}
}
