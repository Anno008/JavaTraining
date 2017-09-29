package jdbc.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.Statement;

import jdbc.model.City;
import jdbc.model.Country;

@Component
public class CityRepository {

	@Autowired
	private Repository repository;

	@Autowired
	private CountryRepository countryRepository;

	public List<City> get() {
		List<City> retVal = new ArrayList<City>();
		try {
			ResultSet resultSet = repository.getConn().createStatement()
					.executeQuery("select city.id, city.name, country.id, country.name, country.population"
							+ " from city left join country on city.country_id = country.id");
			while (resultSet.next()) {
				int cityId = resultSet.getInt(1);
				String cityName = resultSet.getString(2);
				int countryId = resultSet.getInt(3);
				String countryName = resultSet.getString(4);
				int population = resultSet.getInt(5);

				retVal.add(new City(cityId, cityName, new Country(countryId, countryName, population)));
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retVal;
	}

	public City get(int id) {
		City retVal = null;
		try {
			PreparedStatement sqlQuery = repository.getConn()
					.prepareStatement("select city.id, city.name, country.id, country.name, country.population"
							+ " from city left join country on city.country_id = country.id where city.id = ?");
			sqlQuery.setInt(1, id);
			ResultSet resultSet = sqlQuery.executeQuery();

			if (resultSet.next()) {
				int cityId = resultSet.getInt(1);
				String cityName = resultSet.getString(2);
				int countryId = resultSet.getInt(3);
				String countryName = resultSet.getString(4);
				int population = resultSet.getInt(5);

				retVal = new City(cityId, cityName, new Country(countryId, countryName, population));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public List<City> getByName(String name) {
		List<City> retVal = new ArrayList<City>();
		try {
			PreparedStatement sqlQuery = repository.getConn()
					.prepareStatement("select city.id, city.name, country.id, country.name, country.population"
							+ " from city left join country on city.country_id = country.id" + "where city.name like ?");

			sqlQuery.setString(1, "%" + name + "%");
			ResultSet result = sqlQuery.executeQuery();
			while (result.next()) {
				int cityId = result.getInt(1);
				String cityName = result.getString(2);
				int countryId = result.getInt(3);
				String countryName = result.getString(4);
				int population = result.getInt(5);

				retVal.add(new City(cityId, cityName, new Country(countryId, countryName, population)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return retVal;
	}

	public City save(City city) {
		return city.getId() > 0 ? updateCity(city) : createCity(city);
	}

	private City createCity(City city) {
		City retVal = null;
		try {
			PreparedStatement sqlQuery = repository.getConn().prepareStatement(
					"insert into city (name, country_id) values(?,?)", Statement.RETURN_GENERATED_KEYS);
			sqlQuery.setString(1, city.getName());
			sqlQuery.setInt(2, city.getCountry().getId());
			int rowsAffected = sqlQuery.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet keys = sqlQuery.getGeneratedKeys();
				keys.next();
				int id = keys.getInt(1);

				retVal = new City(id, city.getName(), countryRepository.get(city.getCountry().getId()));
			}
			sqlQuery.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	private City updateCity(City city) {
		City retVal = null;
		try {
			PreparedStatement sqlQuery = repository.getConn()
					.prepareStatement("update city set name = ?, country_id = ? where id = ?");
			sqlQuery.setString(1, city.getName());
			sqlQuery.setInt(2, city.getCountry().getId());
			sqlQuery.setInt(3, city.getId());

			int rowsAffected = sqlQuery.executeUpdate();
			if (rowsAffected > 0) {
				retVal = city;
			}
			sqlQuery.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public void delete(int id) {
		try {
			PreparedStatement statement = repository.getConn().prepareStatement("delete from city where id = ?");
			statement.setInt(1, id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
