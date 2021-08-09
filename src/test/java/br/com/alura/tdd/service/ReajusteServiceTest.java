package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @Before
    public void inicializar(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Francilene Silva ", LocalDate.now(), new BigDecimal("1000.00"));

    }

    @After
    public void finalizar(){
        System.out.println("Teste Finalizado");
    }

   // @BeforeClass -> antes de todos - precisa ser static
    @BeforeClass
    public static void antesDeTodos(){
        System.out.println("ANTES DE TODOS");

    }
    //@AfterClass -> depois de todos - precisa ser static
    @AfterClass
    public static void depoisDeTodos(){
        System.out.println("DEPOIS DE TODOS");

    }

    @Test
    public void reajusteDe3PorcentoComDesempenhoAdesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDe15PorcentoComDesempenhoBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDe20PorcentoComDesempenhoOtimo(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
