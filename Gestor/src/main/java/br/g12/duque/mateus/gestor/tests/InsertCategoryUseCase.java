/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.g12.duque.mateus.gestor.tests;

import br.g12.duque.mateus.dao.CategoryDao;
import br.g12.duque.mateus.models.Category;
import javax.swing.JOptionPane;

/**
 *
 * @author judok
 */
public class InsertCategoryUseCase {

    public static void main(String[] args) {
        Category cat = new Category(); // instanciando a categoria
        String name = JOptionPane.showInputDialog("Nome:"); // criando variaveis para 
        String description = JOptionPane.showInputDialog("Descrição:");
        cat.setName(name); // inserindo as variaveis
        cat.setDescription(description);

        CategoryDao cd = new CategoryDao(cat); // instanciando a categoria data access object
        boolean success = cd.insert(); // atribuindo o retorno da função insert para a variavel sucesso

        if (success) {
            JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar registro!");

        }
    }
}
