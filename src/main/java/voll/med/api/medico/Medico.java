package voll.med.api.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import voll.med.api.endereco.Endereco;

@Table(name="cad_medico")
@Entity(name="Medico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidades especialidade;

    @Embedded
    private Endereco endereco;

    private Integer ativo;

    public Medico() {}

    public Medico(DadosCadastroMedico dadosMedico) {
        this.ativo = 1;
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.telefone = dadosMedico.telefone();
        this.crm = dadosMedico.crm();
        this.especialidade = dadosMedico.especialidade();
        this.endereco = new Endereco(dadosMedico.endereco());

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidades getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidades especialidade) {
        this.especialidade = especialidade;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoMedico dados) {

        if (null != dados.nome())
            this.nome = dados.nome();

        if (null != dados.telefone())
            this.telefone = dados.telefone();

        if (null != dados.email())
            this.email = dados.email();

        if (null != dados.endereco())
            this.endereco.atualizarEndereco(dados.endereco());
    }

    public void excluir() {
        this.ativo = 0;
    }
}
