package voll.med.api.domain;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import voll.med.api.dto.DadosEndereco;

@Embeddable
@Getter
@AllArgsConstructor
public class Endereco {

    private String logradouro;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String numero;
    private String complemento;

    public Endereco() {}

    public Endereco(DadosEndereco endereco) {

        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cidade = endereco.cidade();
        this.cep = endereco.cep();
        this.uf = endereco.uf();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
    }

    public void atualizarEndereco(DadosEndereco dados) {

        if (null != dados.logradouro())
            this.logradouro = dados.logradouro();

        if (null != dados.bairro())
            this.bairro = dados.bairro();

        if (null != dados.cidade())
            this.cidade = dados.cidade();

        if (null != dados.cep())
            this.cep = dados.cep();

        if (null != dados.uf())
            this.uf = dados.uf();

        if (null != dados.numero())
            this.numero = dados.numero();

        if (null != dados.complemento())
            this.complemento = dados.complemento();
    }
}
