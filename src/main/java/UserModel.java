import com.github.javafaker.Faker;

public class UserModel {

    private final String name;
    private final String password;
    private final String email;

    static Faker faker = new Faker();
    protected static final String NAME = faker.name().firstName() + System.currentTimeMillis();
    protected static final String EMAIL = NAME.toLowerCase() + "@pochta.ru";
    protected static final String PASSWORD = faker.regexify("[0-9]{6}");

    public UserModel(String email, String password, String name) {
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
