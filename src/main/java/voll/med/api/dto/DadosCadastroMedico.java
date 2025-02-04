package voll.med.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import voll.med.api.domain.enu.Especialidades;

public record DadosCadastroMedico(

        @NotBlank
        String nome,

        @Email
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        @NotNull
        Especialidades especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco
) {

}

