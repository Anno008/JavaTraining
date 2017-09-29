package jdbc.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.Statement;

import jdbc.model.Country;

@Component
public class CountryRepository {

	@Autowired
	private Repository repository;

	public List<Country> get() {
		List<Country> retVal = new ArrayList<Country>();
		try {
			ResultSet resultSet = repository.getConn().createStatement().executeQuery("select id, name, population from country");
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int population = resultSet.getInt("population");

				retVal.add(new Country(id, name, population));
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retVal;
	}
	
	public Country get(int id) {
		Country retVal = null;
		try {
			PreparedStatement sqlQuery = repository.getConn().prepareStatement("select id, name, population from country where id = ?");
			sqlQuery.setInt(1, id);
			ResultSet resultSet = sqlQuery.executeQuery();
			
			if (resultSet.next()) {
				String name = resultSet.getString("name");
				int population = resultSet.getInt("population");

				retVal = new Country(id, name, population);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public List<Country> getByName(String name) {
		List<Country> retVal = new ArrayList<Country>();
		try {
			PreparedStatement statement = repository.getConn().prepareStatement("select id, name, population from country where name like ?");
			statement.setString(1, "%" + name + "%");
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				int id = result.getInt("id");
				String countryName = result.getString("name");
				int population = result.getInt("population");
				
				retVal.add(new Country(id, countryName, population));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return retVal;
	}
	
	public Country save(Country country) {
		return country.getId() > 0 ? updateCountry(country) : createCountry(country);
	}
	
	private Country createCountry(Country country) {
		Country retVal = null;
		try {
			PreparedStatement sqlQuery = repository.getConn().prepareStatement("insert into country (name, population) values(?,?)", Statement.RETURN_GENERATED_KEYS);
			sqlQuery.setString(1, country.getName());
			sqlQuery.setInt(2, country.getPopulation());
			
			int rowsAffected = sqlQuery.executeUpdate();
			if(rowsAffected > 0) {
				ResultSet keys = sqlQuery.getGeneratedKeys();
				keys.next();
				
				int id = keys.getInt(1);
				retVal = new Country(id, country.getName(), country.getPopulation());
			}
			sqlQuery.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	private Country updateCountry(Country country) {
		Country retVal = null;
		try {
			PreparedStatement sqlQuery = repository.getConn().prepareStatement("update country set name = ?, population = ? where id = ?");
			sqlQuery.setString(1, country.getName());
			sqlQuery.setInt(2, country.getPopulation());
			sqlQuery.setInt(3, country.getId());
			
			int rowsAffected = sqlQuery.executeUpdate();
			if(rowsAffected > 0) {
				retVal = country;
			}
			sqlQuery.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public void delete(int id) {
		try {
			PreparedStatement statement = repository.getConn().prepareStatement("delete from country where id = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
