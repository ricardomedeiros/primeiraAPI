package voll.med.api.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String telefone,
        String nome,
        String email,
        DadosEndereco endereco) {
}
