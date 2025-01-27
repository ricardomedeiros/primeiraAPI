package voll.med.api.medico;

import jakarta.validation.constraints.NotNull;
import voll.med.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String telefone,
        String nome,
        String email,
        DadosEndereco endereco) {
}
