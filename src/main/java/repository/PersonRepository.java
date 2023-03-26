package repository;

import models.Person;

import java.sql.*;

public class PersonRepository extends CRUDRepository <Person> {

    private static final String allPeople = "SELECT * FROM person";
    private static final String personWhereAgeUnder = "SELECT * FROM person WHERE age > ?";
    private static final String deletePerson = "DELETE FROM person WHERE id = ?";
    private static final String findPersonById = "SELECT * FROM person WHERE id = ?";
    private static final String savedPerson = "INSERT INTO person(first_name, last_name,age) VALUES (?,?,?)";
    private static final String updateInfo = "UPDATE person SET first_name = ?, last_name = ?, age = ? WHERE id = ?";
    private static final String findByName = "SELECT * FROM person WHERE first_name = ?";

    @Override
    protected Person extractEntityFromResultSet(ResultSet resultSet) throws SQLException {
        int personId = resultSet.getInt("id");
        String personFName = resultSet.getString("first_name");
        String personLName = resultSet.getString("last_name");
        int age = resultSet.getInt("age");
        return new Person(personId,personFName,personLName, age);
    }

    @Override
    protected void mapForSave(Person person, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, person.getFirstName());
        preparedStatement.setString(2, person.getLastName());
        preparedStatement.setString(3, String.valueOf(person.getAge()));
    }

    @Override
    protected String getSqlForSelectingById() {
        return findPersonById;
    }

    @Override
    protected String getSqlForSelectingWhereAgeUnder() {
        return personWhereAgeUnder;
    }

    @Override
    public String getSavePersonSql() {
        return savedPerson;
    }

    @Override
    protected String getSqlForSelecting() {
        return allPeople;
    }

    @Override
    protected String getSqlToDeletePerson() {
        return deletePerson;
    }

    @Override
    protected String getSqlForUpdate() {
        return updateInfo;
    }

    @Override
    protected String getSqlForSelectingByName() {
        return findByName;
    }
}
