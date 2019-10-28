package br.com.fiap.user;

import br.com.fiap.user.entity.Historico;
import br.com.fiap.user.entity.User;
import br.com.fiap.user.entity.VerMaisTarde;
import br.com.fiap.user.repository.HistoricoRepository;
import br.com.fiap.user.repository.UserRepository;
import br.com.fiap.user.repository.VerMaisTardeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class UserApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    HistoricoRepository historicoRepository;

    @Autowired
    VerMaisTardeRepository verMaisTardeRepository;


    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Override
    public void run(String... args){

        List<User> userList = new ArrayList<>();

        User user = new User();
        user.setNome("Otavio");
        user.setUsername("teste");
        user.setPassword("teste");
        userList.add(user);

        User user1 = new User();
        user1.setNome("Marcelo");
        user1.setUsername("teste");
        user1.setPassword("teste");
        userList.add(user1);

        User user2 = new User();
        user2.setNome("Aldenir");
        user2.setUsername("teste");
        user2.setPassword("teste");
        userList.add(user2);

        userRepository.saveAll(userList);

        List<Historico> historicoList = new ArrayList<>();

        Historico historico = new Historico();

        historico.setIdMovie(1);
        historico.setIdUser(user);
        historicoList.add(historico);


        Historico historico2 = new Historico();

        historico2.setIdMovie(2);
        historico2.setIdUser(user1);
        historicoList.add(historico2);

        Historico historico3 = new Historico();

        historico3.setIdMovie(3);
        historico3.setIdUser(user2);
        historicoList.add(historico3);

        Historico historico4 = new Historico();

        historico4.setIdMovie(3);
        historico4.setIdUser(user);
        historicoList.add(historico4);

        Historico historico5 = new Historico();

        historico5.setIdMovie(2);
        historico5.setIdUser(user1);
        historicoList.add(historico5);

        Historico historico6 = new Historico();

        historico6.setIdMovie(1);
        historico6.setIdUser(user1);
        historicoList.add(historico6);

        historicoRepository.saveAll(historicoList);


        List<VerMaisTarde> verMaisTardeArrayList = new ArrayList<>();

        VerMaisTarde verMaisTarde = new VerMaisTarde();

        verMaisTarde.setIdMovie(1);
        verMaisTarde.setIdUser(user);
        verMaisTardeArrayList.add(verMaisTarde);

        VerMaisTarde verMaisTarde2 = new VerMaisTarde();

        verMaisTarde2.setIdMovie(1);
        verMaisTarde2.setIdUser(user);
        verMaisTardeArrayList.add(verMaisTarde2);

        verMaisTardeRepository.saveAll(verMaisTardeArrayList);
    }
}
