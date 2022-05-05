package br.com.daniel.loteria.service;

import br.com.daniel.loteria.dto.SorteioResponse;
import br.com.daniel.loteria.model.Sorteio;
import br.com.daniel.loteria.model.Usuario;
import br.com.daniel.loteria.repository.SorteioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SorteioService {

    @Autowired
    private SorteioRepository sorteioRepository;

    public Sorteio criaSorteio(Usuario usuario) {

        String numero = geraNumeroAleatorio();

        while (sorteioRepository.existsByNumeroSorteadoAndUsuario_Cpf(numero, usuario.getCpf())) {
            numero = geraNumeroAleatorio();
        }

        Sorteio sorteio = new Sorteio(numero, usuario);
        return sorteioRepository.save(sorteio);

    }


    private String geraNumeroAleatorio() {

        Random random = new Random();

        return String.format("%04d", random.nextInt(999) + 1);


    }

    public List<SorteioResponse> listaSorteios(Usuario usuario) {

        List<Sorteio> sorteios = sorteioRepository.findAllByUsuario_Id(usuario.getId());

        return sorteios.stream().map(SorteioResponse::new).collect(Collectors.toList());


    }
}
