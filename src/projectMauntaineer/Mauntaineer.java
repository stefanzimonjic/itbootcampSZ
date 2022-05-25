package projectMauntaineer;

public abstract class Mauntaineer {

    private int id;
    private String firstName;
    private String lastName;

    public Mauntaineer() {
    }

    public Mauntaineer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract double membershipCalculation();

    public abstract boolean successfulAscent(Mauntain mauntain);

    public abstract void print();

    @Override
    public String toString() {
        return "id: " + id + "\n" +
                "ime: " + firstName + " " + lastName + "\n";
    }
}
