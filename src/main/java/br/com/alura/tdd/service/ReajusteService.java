package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste (Funcionario funcionario, Desempenho desempenho) {
        BigDecimal percentual = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(reajuste);
    }


    /*FUNCIONALIDADE PARA IMPLEMENTAÇÃO
    * EX:
    * Funcionalidade - Reajuste baseado no desempenho anual
    * O sistema deve permitir que os funcionarios recebam um reajuste salarial anual baseado em seu
    * desempenho, obedecendo às seguintes regras:
    * Se o desempenho foi "A desejar", Reajuste será de apenas 3% do salário;
    * Se o desempenho foi "Bom", reajuste será de 15% do salário;
    * Se o desempenho foi "Ótimo", o reajuste será de 20% do salário.*/
}
