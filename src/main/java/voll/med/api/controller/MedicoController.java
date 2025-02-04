package voll.med.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import voll.med.api.domain.Medico;
import voll.med.api.dto.DadosAtualizacaoMedico;
import voll.med.api.dto.DadosCadastroMedico;
import voll.med.api.dto.DadosListagemMedicos;
import voll.med.api.services.MedicoService;

@RestController
@RequestMapping("/medicos")
@AllArgsConstructor
public class MedicoController {

    private MedicoService medicoService;

    @PostMapping
    @Transactional
    public void incluirMedico(@RequestBody @Valid DadosCadastroMedico dadosMedico) {
        medicoService.incluirMedico(new Medico(dadosMedico));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listarMedicosPaginacao(Pageable paginacao) {
        return medicoService.listar(paginacao).map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizarMedicos(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        medicoService.atualizarMedico(dados);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirMedico(@PathVariable Long id) {
        if (!medicoService.existeMedico(id))
            return ResponseEntity.notFound().build();

        medicoService.excluirMedico(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/logico/{id}")
    public ResponseEntity<Void> excluirLogicoMedico(@PathVariable Long id) {
        if (!medicoService.existeMedico(id))
            return ResponseEntity.notFound().build();

        medicoService.excluirLogicoMedico(id);
        return ResponseEntity.noContent().build();
    }
}
