package voll.med.api.domain;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import voll.med.api.dto.DadosAtualizacaoMedico;
import voll.med.api.dto.DadosCadastroMedico;
import voll.med.api.domain.enu.Especialidades;

@Table(name="cad_medico")
@Entity(name="Medico")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
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
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.telefone = dadosMedico.telefone();
        this.crm = dadosMedico.crm();
        this.especialidade = dadosMedico.especialidade();
        this.ativo = 1;
        this.endereco = new Endereco(dadosMedico.endereco());
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

    // 0 - inativo; 1 - ativo
    public void excluir() {
        this.ativo = 0;
    }
}
