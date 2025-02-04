package voll.med.api.dto;

import voll.med.api.domain.enu.Especialidades;
import voll.med.api.domain.Medico;

public record DadosListagemMedicos(Long id, String nome, String email, String crm, Especialidades especialidade) {

    public DadosListagemMedicos(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}