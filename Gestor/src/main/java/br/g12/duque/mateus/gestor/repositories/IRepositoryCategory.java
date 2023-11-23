/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.g12.duque.mateus.gestor.repositories;

import br.g12.duque.mateus.models.Category;
import java.util.ArrayList;

/**
 *
 * @author judok
 */
public interface IRepositoryCategory {
    public boolean insert(); // Métodos abstratos // clean code
    public boolean update();
    public boolean delete();
    public ArrayList findAll();
    public Category findById(int id); //parametros ==> variaveis locais
}
