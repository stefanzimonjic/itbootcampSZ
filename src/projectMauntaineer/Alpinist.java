package projectMauntaineer;

public class Alpinist extends Mauntaineer{

    private int points;

    public Alpinist() {
    }

    public Alpinist(int id, String firstName, String lastName, int points) {
        super(id, firstName, lastName);
        setPoints(points);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        if (points >= 0) {
            this.points = points;
        } else System.err.println("Value of point can't be negative");
    }

    public boolean successfulAscent(Mauntain mauntain) {
        return mauntain.getHeight() <= 4000;
    }

    public double membershipCalculation() {
        int membership = 1500 - (this.points * 50);
        if (membership > 0) {
            return membership;
        }
        return 0;
    }

    public void print() {
        System.out.println("Alpinist " + super.toString() + "\n" + "Number of points:" + points);
    }
}
