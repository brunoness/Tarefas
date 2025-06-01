package com.br.tarefa33;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.br.tarefa33.DAO.AcessorioDAO;
import com.br.tarefa33.DAO.MarcaDAO;
import com.br.tarefa33.domain.Acessorio;
import com.br.tarefa33.domain.Carro;
import com.br.tarefa33.domain.Marca;
import com.br.tarefa33.service.CarroService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarroTeste {

    @Autowired
    private CarroService carroService;

    @Autowired
    private MarcaDAO marcaDAO;

    @Autowired
    private AcessorioDAO acessorioDAO;

    @Test
    void testSalvarCarroComMarcaEAcessorios() {
        Marca marca = new Marca();
        marca.setNome("Fiat");
        marca = marcaDAO.save(marca);

        Acessorio rodas = new Acessorio();
        rodas.setNome("Rodas esportivas");
        acessorioDAO.save(rodas);

        Carro carro = new Carro();
        carro.setModelo("Pulse");
        carro.setAno(2023);
        carro.setMarca(marca);
        carro.setAcessorios(List.of(rodas));

        Carro salvo = carroService.salvar(carro);
        assertNotNull(salvo.getId());
    }
}
