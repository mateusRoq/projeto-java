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
 * @author 08060
 */
public class UpdateCategoryUseCase {
    public static void main(String[] args) {
        String strCodigo = JOptionPane.showInputDialog(null, "Digite o código");
        String name = JOptionPane.showInputDialog(null, "Novo nome:");
        String description = JOptionPane.showInputDialog(null, "Nova descrição");
        int code = Integer.valueOf(strCodigo);
        
        Category cat = new Category(code, name, description);
        
        CategoryDao dao = new CategoryDao(cat);
        
        boolean success = dao.update();
        
        if(success){
            JOptionPane.showMessageDialog(null, "Registro atualizado!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na atualização");
        }
    }
}
