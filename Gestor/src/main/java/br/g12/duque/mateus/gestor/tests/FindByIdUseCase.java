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
public class FindByIdUseCase {
    public static void main(String[] args) {
        // 1. criar objeto do tipo category
        Category cat = new Category();
        
        // 2. criar o objeto dao
        
        // 3. criar um objeto para armazenar a categoria encontrada (se houver)
        Category categoryFound = null;
        
        // 4. Exectuar o método findById do Dao
        String strCodigo = JOptionPane.showInputDialog(null, "Digite o código");
        int codigo = Integer.valueOf(strCodigo);
        cat.setId(codigo);
        
        CategoryDao dao = new CategoryDao(cat);
        categoryFound = dao.findById();
        System.out.println(categoryFound);
    }
}
