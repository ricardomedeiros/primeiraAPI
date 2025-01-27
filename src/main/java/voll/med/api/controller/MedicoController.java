package voll.med.api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import voll.med.api.medico.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void incluirMedico(@RequestBody @Valid DadosCadastroMedico dadosMedico) {
        repository.save(new Medico(dadosMedico));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listarMedicos(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedicos(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirMedico(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @DeleteMapping("/logico/{id}")
    @Transactional
    public void excluirLogicoMedico(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }
}
