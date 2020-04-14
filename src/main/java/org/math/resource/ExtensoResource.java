package org.math.resource;

import org.math.enuns.Language;
import org.math.exception.WrongValueException;
import org.math.model.ResponsePorExtenso;
import org.math.service.PorExtensoFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/extenso")
public class ExtensoResource {


    @GetMapping(value = "/{numero}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponsePorExtenso> getNumeroPorExtenso(@PathVariable(value = "numero") Integer numero,
                                                  @RequestParam(value = "linguagem", defaultValue = "PT", required = false) String linguagem) {
        validarParametros(numero, linguagem);
        String resultadoPorExtenso = PorExtensoFactory
                .getPorExtensoInstance(Language.valueOf(linguagem))
                .resultado(numero);
        return new ResponseEntity<>(new ResponsePorExtenso(resultadoPorExtenso), HttpStatus.OK);
    }

    private void validarParametros(Integer numero,
                                   String linguagem) {
        validarNumero(numero);
        validarLinguagem(linguagem);
    }

    private void validarLinguagem(String linguagem) {
        if (Language.notContains(linguagem)) {
            throw new WrongValueException(String.format("The Param 'linguagem' was incorrect. Accept values  are: '%s'", Language.description()));
        }
    }

    private void validarNumero(Integer numero) {
        if (numero > 100_000 || numero < -100_000) {
            throw new WrongValueException("The Param 'numero' have to be in range [-99999, 99999]");
        }
    }


}
