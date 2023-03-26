package repository;

import db.DBConnection;
import models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class CRUDRepository <T> {

    DBConnection dbConnection = new DBConnection();

    // Додати користувача
    public void addPerson(T entity) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(getSavePersonSql());
            mapForSave(entity, prepareStatement);
            prepareStatement.execute();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Вивести всіх користувачів
    public void findAllPeople() {
        Connection connection = dbConnection.getConnection();
        ArrayList<T> people = new ArrayList<>();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(getSqlForSelecting());
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                people.add(extractEntityFromResultSet(resultSet));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        people.forEach(person -> System.out.println(person.toString()));
    }

    //Вивести всіх користувачів які старші заданому віку(вік задаєм з консолі)
    public void getPersonWhereAgeUnder(int age){
        Connection connection = dbConnection.getConnection();
        ArrayList<T> entities = new ArrayList<>();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(getSqlForSelectingWhereAgeUnder());
            prepareStatement.setString(1, String.valueOf(age));
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(extractEntityFromResultSet(resultSet));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        entities.forEach(person -> System.out.println(person.toString()));
    }

    //Видалити користувача
    public void deletePerson(int id){
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(getSqlToDeletePerson());
            prepareStatement.setString(1, String.valueOf(id));
            prepareStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Оновити дані про користувача
    public void updatePerson(int id, Person person){
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(getSqlForUpdate());
            prepareStatement.setString(1, String.valueOf(id));
            prepareStatement.setString(2, person.getFirstName());
            prepareStatement.setString(3, person.getLastName());
            prepareStatement.setString(4, String.valueOf(person.getAge()));
            prepareStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Отримати користувача по ID
    public void findById(int id) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(getSqlForSelectingById());
            prepareStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(extractEntityFromResultSet(resultSet));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Отримати користувача по firstName
    public void getPersonWhereName(String name) {
        Connection connection = dbConnection.getConnection();
        try {
            PreparedStatement prepareStatement = connection.prepareStatement(getSqlForSelectingByName());
            prepareStatement.setString(1, String.valueOf(name));
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(extractEntityFromResultSet(resultSet));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected abstract T extractEntityFromResultSet(ResultSet result) throws SQLException;

    protected abstract void mapForSave(T entity, PreparedStatement preparedStatement) throws SQLException;

    protected abstract String getSqlForSelectingById() throws SQLException;

    protected abstract String getSqlForSelectingWhereAgeUnder() throws SQLException;

    public abstract String getSavePersonSql() throws SQLException;

    protected abstract String getSqlForSelecting() throws SQLException;

    protected abstract String getSqlToDeletePerson() throws SQLException;

    protected abstract String getSqlForUpdate();

    protected abstract String getSqlForSelectingByName();

}
