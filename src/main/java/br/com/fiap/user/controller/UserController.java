package br.com.fiap.user.controller;

import br.com.fiap.user.entity.Historico;
import br.com.fiap.user.entity.User;
import br.com.fiap.user.repository.HistoricoRepository;
import br.com.fiap.user.repository.UserRepository;

import br.com.fiap.user.repository.VerMaisTardeRepository;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;


@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HistoricoRepository historicoRepository;

    @Autowired
    VerMaisTardeRepository verMaisTardeRepository;


    @ApiOperation(
            value="insere historico relacionado a um usuario ",
            response= Historico.class,
            notes="Essa operação insere historico relacionado a um usuario")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Inserção feita com sucesso",
                    response= Historico.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=Historico.class
            )

    })
    @PostMapping("/historico/")
    public String setHistorico(@RequestBody Historico historico){

        return new Gson().toJson(historicoRepository.save(historico));
    }


    @ApiOperation(
            value="Consulta historico relacionado a um usuario ",
            response= Historico.class,
            notes="Essa operação Consulta historico relacionado a um usuario")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Consulta feita com sucesso",
                    response= Historico.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=Historico.class
            )

    })
    @GetMapping("/historico/{id}")
    public String getHistorico(@PathVariable("id") Long id){

        ArrayList bodyRest = new ArrayList();

        bodyRest.addAll(historicoRepository.findHistorico(id));

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(bodyRest.toString(), headers);

        ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:8090/movie/array/", entity , String.class );

        return response.getBody();
    }

    @ApiOperation(
            value="insere um usuario ",
            response= Historico.class,
            notes="Essa operação insere um usuario")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Inserção feita com sucesso",
                    response= Historico.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=Historico.class
            )

    })
    @PostMapping("/user/")
    public String isertUser(@RequestBody User user){

        return new Gson().toJson(userRepository.save(user));
    }


    @ApiOperation(
            value="Consulta historico relacionado a um usuario ",
            response= int.class,
            notes="Essa operação Consulta historico relacionado a um usuario")
    @ApiResponses(value= {
            @ApiResponse(
                    code=200,
                    message="Consulta feita com sucesso",
                    response= int.class
            ),
            @ApiResponse(
                    code=500,
                    message="Erro",
                    response=int.class
            )

    })
    @GetMapping("/assistirdepois/{id}")
    public String getAssisitirDepois(@PathVariable("id") Long id){

     ArrayList bodyRest = new ArrayList();

        bodyRest.addAll(verMaisTardeRepository.findVerMaisTarde(id));

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(bodyRest.toString(), headers);

        ResponseEntity<String> response = restTemplate.postForEntity( "http://localhost:8090/movie/array/", entity , String.class );

        return response.getBody();
    }



}
