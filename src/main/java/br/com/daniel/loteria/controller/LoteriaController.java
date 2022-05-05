package br.com.daniel.loteria.controller;

import br.com.daniel.loteria.dto.SorteioResponse;
import br.com.daniel.loteria.dto.UsuarioRequest;
import br.com.daniel.loteria.model.Sorteio;
import br.com.daniel.loteria.model.Usuario;
import br.com.daniel.loteria.service.SorteioService;
import br.com.daniel.loteria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/loterias")
public class LoteriaController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SorteioService sorteioService;


    @PostMapping
    public ResponseEntity<?> cadastraNovoSorteio(@RequestBody @Valid UsuarioRequest request) {

        Usuario usuario = usuarioService.validaUsuario(request);

        Sorteio sorteio = sorteioService.criaSorteio(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(new SorteioResponse(sorteio));


    }


    @GetMapping("/{usuarioId}")
    public ResponseEntity<List> listaSorteios(@PathVariable Long usuarioId) {

        Usuario usuario = usuarioService.localizaUsuario(usuarioId);

        List<SorteioResponse> sorteios = sorteioService.listaSorteios(usuario);

        return ResponseEntity.status(HttpStatus.OK).body(sorteios);


    }

}
