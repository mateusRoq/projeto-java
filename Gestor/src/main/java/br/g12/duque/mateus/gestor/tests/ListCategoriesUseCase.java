/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.g12.duque.mateus.gestor.tests;

import br.g12.duque.mateus.dao.CategoryDao;
import br.g12.duque.mateus.models.Category;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author 08060
 */
public class ListCategoriesUseCase {
    public static void main(String[] args) {
        // 1. Criar um arrayList vazio
        ArrayList <Category> list = null;
        
        //2. Criar um objeto dao para buscar os dados
        Category cat = new Category();
        CategoryDao dao = new CategoryDao(cat);
        
        list = dao.findAll();
        String message = "";
//        System.out.println(list); o famoso forEach do javascript
        for (Category c : list) {
            
            message += c.getName() + "\n";
            
        }
        JOptionPane.showMessageDialog(null, message);
    }
}
