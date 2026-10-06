package testPackage;

import net.datafaker.Faker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FakerData {

    private Faker faker = new Faker(new Locale("en"));

    public  final String firstName = faker.name().firstName();
    public  final String lastName = faker.name().lastName();
    public  final String mail = faker.internet().emailAddress();
    public  final String address = faker.address().streetAddress();
    public  final String city = faker.address().city();
    public  final String year = String.valueOf(faker.number().numberBetween(1999, 2015));
    public  final String day = String.format("%02d", faker.number().numberBetween(1, 28));
    public  final String month = faker.options().option("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
    public  final String gender = faker.options().option("Male", "Female", "Other");
    public  final String number = faker.number().digits(10);

    public  final String badMail = faker.name().firstName().toLowerCase(); // можно любую херню
    public  final String badNumber = faker.number().digits(8);

    public  final String maths = faker.options().option("Maths", "Physics", "Chemistry", "Computer Science", "English",
            "Biology", "History", "Economics", "Accounting", "Commerce", "Arts", "Social Studies", "Civics");

    public  final String region = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public  final String cityIndia = switch (region) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> throw new IllegalArgumentException("Unknown region: " + region);
    };

    public  final List<String> hobbies = randomHobbies();

    private  List<String> randomHobbies() {
        List<String> all = new ArrayList<>(List.of("Sports", "Reading", "Music"));
        Collections.shuffle(all);
        return all.subList(0, 2);
    }

    public final String photo = "photo_2024-06-26_21-07-42.jpg";

}
