package countriesMavenSpring.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import countriesMavenSpring.model.Country;
import countriesMavenSpring.service.CountryService;
import countriesMavenSpring.utility.Utility;

@Component
public class CountryView {

	@Autowired
	private CountryService countryService;

	public void start() {
		int option = 0;

		do {
			displayMenu();
			option = Utility.readInteger("\nPlease chose the desired option: ");

			switch (option) {
			case 1:
				showAllCountries();
				break;
			case 2:
				findCountry();
				break;
			case 3:
				addCountry();
				break;
			case 4:
				modifyCountry();
				break;
			case 5:
				removeCountry();
				break;
			}
		} while (option != 6);
	}

	private void removeCountry() {
		int id = Utility.readInteger("Enter the id of the country: ");
		countryService.delete(id);
	}

	private void modifyCountry() {
		int id = Utility.readInteger("Enter the id of the country: ");
		String name = Utility.readString("Enter the name of the country");
		int population = Utility.readInteger("Enter the population of the country: ");

		countryService.save(new Country(id, name, population));
	}

	private void addCountry() {
		int id = Utility.readInteger("Enter the id of the country: ");
		String name = Utility.readString("Enter the name of the country");
		int population = Utility.readInteger("Enter the population of the country: ");

		countryService.save(new Country(id, name, population));
	}

	private void findCountry() {
		int id = Utility.readInteger("\nEnter the id of the desired country: ");
		Country country = countryService.find(id);
		System.out.println(country == null ? "The country with the id of: " + id + " doesn't exist" : country);
	}

	private void showAllCountries() {
		for (Country country : countryService.findAll())
			System.out.println(country);
	}

	private void displayMenu() {
		System.out.println("1. Display countries.");
		System.out.println("2. Find a country.");
		System.out.println("3. Add country.");
		System.out.println("4. Modify country.");
		System.out.println("5. Delete country.");
		System.out.println("6. Exit");
	}
}
