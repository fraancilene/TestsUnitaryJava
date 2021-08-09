package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;

public class ReajusteServiceTest {

    @Test
    public void reajusteDe3PorcentoComDesempenhoAdesejar(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Pedro Europeu", 
                LocalDate.now(), new BigDecimal("1000.00"));
        
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDe15PorcentoComDesempenhoBom(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Francilene Silva", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDe20PorcentoComDesempenhoOtimo(){
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Nicholas Silva", LocalDate.now(), new BigDecimal("1000.00"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
