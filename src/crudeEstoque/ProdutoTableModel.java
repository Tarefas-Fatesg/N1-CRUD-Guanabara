/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudeEstoque;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel {

    private static final long serialVersionUID = 1L;
    /* Lista de Produto que representam as linhas. */

    private List<Produto> linhas;
    /* Array de Strings com o nome das colunas. */

    private String[] colunas = new String[]{
        //---------"Nome", "Endereço", "Telefone"};
          "Codigo", "Nome", "Qtd estoque","Und Medida","Valor venda","Valor compra","Qtd estoque min"};
    /* Cria um ProdutoTableModel vazio. */

    public ProdutoTableModel() {
        linhas = new ArrayList<Produto>();
    }

    /* Cria um ProdutoTableModel carregado com
     * a lista de Produto especificada. */
    public ProdutoTableModel(List<Produto> listaDeProduto) {
        linhas = new ArrayList<Produto>(listaDeProduto);
    }

    /* Retorna a quantidade de colunas. */
    @Override
    public int getColumnCount() {
        // EstÃ¡ retornando o tamanho do array "colunas".
        return colunas.length;
    }

    /* Retorna a quantidade de linhas. */
    @Override
    public int getRowCount() {
        // Retorna o tamanho da lista de Produto.
        return linhas.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        // Retorna o conteÃºdo do Array que possui o nome das colunas
        return colunas[columnIndex];
    }

    ;
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    ;
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto produto = linhas.get(rowIndex);
        // Retorna o campo referente a coluna especificada.
        // Aqui é feito um switch para verificar qual é a coluna
        // e retornar o campo adequado. As colunas sãoas mesmas
        // que foram especificadas no array "colunas".
        switch (columnIndex) {
            // Seguindo o exemplo: "Tipo","Data de Cadastro", "Nome", "Idade"};
            case 0:
                return produto.getCodigo();
            case 1:
                return produto.getNome();
            case 2:
                return produto.getQtdEstoque();
            case 3:
                return produto.getUnidadeDmedida();
            case 4:
                return produto.getValorVenda();
            case 5:
                return produto.getValorCompra();
            case 6:
                return produto.getQtdEstoqueMin();
            default:
                // Isto não deveria acontecer...
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    //modifica na linha e coluna especificada
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Produto produto = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado
        switch (columnIndex) { // Seta o valor do campo respectivo
            
            case 0:
                produto.setCodigo(Integer.parseInt(aValue.toString()));
            case 1:
                produto.setNome(aValue.toString());
            case 2:
                produto.setQtdEstoque(Integer.parseInt(aValue.toString()));
            case 3:
                produto.setUnidadeDmedida(aValue.toString());
            case 4:
                produto.setValorVenda(Integer.parseInt(aValue.toString()));
            case 5:
                produto.setValorCompra(Integer.parseInt(aValue.toString()));
            case 6:
                produto.setQtdEstoqueMin(Integer.parseInt(aValue.toString()));
      
            
            default:
            // Isto não deveria acontecer...             
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    //modifica na linha especificada
    public void setValueAt(Produto aValue, int rowIndex) {
        Produto produto = linhas.get(rowIndex); // Carrega o item da linha que deve ser modificado
        produto.setCodigo(aValue.getCodigo());
        produto.setNome(aValue.getNome());
        produto.setQtdEstoque(aValue.getQtdEstoque());
        produto.setUnidadeDmedida(aValue.getUnidadeDmedida());
        produto.setValorVenda(aValue.getValorVenda());
        produto.setValorCompra(aValue.getValorCompra());
        produto.setQtdEstoqueMin(aValue.getQtdEstoqueMin());

        fireTableCellUpdated(rowIndex, 0);
        fireTableCellUpdated(rowIndex, 1);
        fireTableCellUpdated(rowIndex, 2);
        fireTableCellUpdated(rowIndex, 3);
        fireTableCellUpdated(rowIndex, 4);
        fireTableCellUpdated(rowIndex, 5);
        fireTableCellUpdated(rowIndex, 6);
        
        
    }

    ;
    ;
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Produto getProduto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }

    /* Adiciona um registro. */
    public void addProduto(Produto m) {
        // Adiciona o registro.
        linhas.add(m);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    /* Remove a linha especificada. */
    public void removeProduto(int indiceLinha) {
        linhas.remove(indiceLinha);
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }

    /* Adiciona uma lista de Produto ao final dos registros. */
    public void addListaDeProduto(List<Produto> produto) {
        // Pega o tamanho antigo da tabela.
        int tamanhoAntigo = getRowCount();
        // Adiciona os registros.
        linhas.addAll(produto);
        fireTableRowsInserted(tamanhoAntigo, getRowCount() - 1);
    }

    /* Remove todos os registros. */
    public void limpar() {
        linhas.clear();
        fireTableDataChanged();
    }

    /* Verifica se este table model esta vazio. */
    public boolean isEmpty() {
        return linhas.isEmpty();
    }
}
