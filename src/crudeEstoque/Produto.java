/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudeEstoque;

/**
 *
 * @author kai
 */
public class Produto {
    
    
    String nome;
    int codigo;
    int qtdEstoque;
    String unidadeDmedida;
    int  valorVenda;
    int valorCompra;
    int qtdEstoqueMin;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getUnidadeDmedida() {
        return unidadeDmedida;
    }

    public void setUnidadeDmedida(String unidadeDmedida) {
        this.unidadeDmedida = unidadeDmedida;
    }

    public int getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(int valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(int valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getQtdEstoqueMin() {
        return qtdEstoqueMin;
    }

    public void setQtdEstoqueMin(int qtdEstoqueMin) {
        this.qtdEstoqueMin = qtdEstoqueMin;
    }
    
    
    
}
