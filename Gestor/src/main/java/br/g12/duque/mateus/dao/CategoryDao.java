/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.g12.duque.mateus.dao;

import br.g12.duque.mateus.gestor.Conexao;
import br.g12.duque.mateus.models.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import br.g12.duque.mateus.gestor.repositories.IRepositoryCategory;

/**
 *
 * @author judok
 */
public class CategoryDao implements IRepositoryCategory {

    private Category category;

    public CategoryDao(Category cat) {
        this.category = cat;
    }

    //Annotation ou Decorator que indica:
    //Que eu vou sobreescrever um método
    @Override
    public boolean insert() {
        String sql = "INSERT INTO categories "
                + "(name, description) VALUES "
                + "(?,?)";
        boolean success = false;  /// definir variavel de confirmação de execução
        Connection conn = Conexao.getConnection(); /// fazer a conexão
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, category.getName());
            pst.setString(2, category.getDescription());
            pst.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            System.out.println("Erro CategoryDao: " + ex.getMessage());
            success = false;
        }
        return success;
    }

    @Override
    public boolean update() {
        // 1. Definir o comando sql que será executado
        String sql = "UPDATE categories SET "
                + "name = ?, description = ? "
                + "WHERE id = ?";

        // 2. Definir a variavel que dirá se a operação foi bem sucedida
        boolean success = false;

        // 3. Conexao com o banco de dados
        Connection conn = Conexao.getConnection();

        /// 4. Inicializar o tratamento de erros da aplicação com a preparação entre banco e dados
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, category.getName());
            pst.setString(2, category.getDescription());
            pst.setInt(3, category.getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro CategoryDao: " + e.getMessage());
            success = false;
        }

        return success;
    }

    @Override
    public boolean delete() {
        // 1. Definir comandos sql a ser executado
        String sql = "DELETE FROM categories WHERE id = ?";

        // 2. Definir a variavel que indica se a operação foi bem sucedida
        boolean success = false;

        // 3. Fazer a conexão com o banco de dados
        Connection conn = Conexao.getConnection();

        // 4. Inicializar o tratamento de erros e o preparamento da conexao
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, category.getId());
            pst.executeUpdate();
            success = true;
        } catch (SQLException e) {
            System.out.println("Erro CategoryDao: " + e.getMessage());
            success = false;
        }

        return success;
    }

    @Override
    public ArrayList findAll() {

        //1. Criar uma lista que armazenará todas as categorias
        ArrayList<Category> list = new ArrayList<Category>();

        boolean success = false;

        //3. Definir qual o comando sql será executado.
        String sql = "SELECT id, name, description FROM categories";

        // 4. Estabelecer conexão com o banco de dados
        Connection conn = Conexao.getConnection();

        // 5. tratemento de erros 
        try {
            // 6. Enviar a query para o banco de dados
            Statement stm = conn.createStatement(); // -> pergunta

            // 7. O banco retorna o resultado da consulta
            ResultSet rs = stm.executeQuery(sql);

            // 8. Salvar o resultado da query dentro da lista
            while (rs.next()) {
                list.add(new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")
                )
                );
            }
        } catch (SQLException e) {
            System.out.println("Erro CategoryDao: " + e.getMessage());
        }
        return list;
    }

    @Override
    public Category findById() {
        String sql = "SELECT name, description FROM categories WHERE id = " + category.getId();

        Category category = null;

        Connection conn = Conexao.getConnection();

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            rs.next(); // mover o cursos para o primeiro resultado encontrado se vier dois, pegará o primeiro

            if (rs.getRow() > 0) {
                category = new Category(rs.getInt("id"), rs.getString("name"), rs.getString("description"));
            } else {
                System.out.println("Categoria não encontrada");
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Erro CategoryDao: " + e.getMessage());
        }
        return category;
    }

}
