package bank.person;

public class Owner {
    private String name;
    private String surname;

    public Owner(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + this.name + '\'' +
                ", surname='" + this.surname + '\'' +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }
}
