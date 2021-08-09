package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Test;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class BonusServiceTest {

    private BonusService service;

    public void inicializa(){

    }

    // testes que retornam exception
    @Test
    public void bonusMaiorQueMil(){
        BonusService service = new BonusService();
        // 1º maneira
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Francilene Silva", LocalDate.now(), new BigDecimal(25000))));

//        // 2º maneira - esta abordagem é util quando queremos pegar a mensagem
//        try {
//            service.calcularBonus(new Funcionario("Francilene Silva", LocalDate.now(), new BigDecimal(25000)));
//            fail("Não deu a exception!");
//        } catch (Exception e){
//          // se entrar no catch - ok
//          // se não entrar - falhou
//            // verigicando a mensagem
//            assertEquals("Funcionario com salário maior do que R$ 10000 não pode receber bônus", e.getMessage());
    }

    @Test
    public void bonusDeveSer10porcentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Francilene Silva",
                LocalDate.now(), new BigDecimal(2500)));


    }

    @Test
    public void bonusDeExatamenteMilReais(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Francilene Silva",
                LocalDate.now(), new BigDecimal(10000)));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
