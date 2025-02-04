package voll.med.api.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import voll.med.api.domain.Medico;
import voll.med.api.domain.exception.NegocioException;
import voll.med.api.dto.DadosAtualizacaoMedico;
import voll.med.api.dto.DadosListagemMedicos;
import voll.med.api.repositories.MedicoRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicoService {

    MedicoRepository medicoRepository;

    public void incluirMedico(Medico medico) {
        medicoRepository.save(medico);
    }

    public Page<Medico> listar(Pageable paginacao) {
        return medicoRepository.findAll(paginacao);
    }

    public void atualizarMedico(DadosAtualizacaoMedico dados) {
        Medico medico = buscarMedico(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @Transactional
    public void excluirMedico(Long idMedico) {
       medicoRepository.deleteById(idMedico);
    }

    @Transactional
    public void excluirLogicoMedico(Long idMedico) {
        Medico medico = buscarMedico(idMedico);
        medico.excluir();
    }

    public Medico buscarMedico(Long idMedico) {
        return medicoRepository.findById(idMedico)
                .orElseThrow(() -> new NegocioException("Médico não encontrado."));
    }

    public boolean existeMedico(Long idMedico) {
        return medicoRepository.existsById(idMedico);
    }
}
