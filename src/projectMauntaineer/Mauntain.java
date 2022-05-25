package projectMauntaineer;

public class Mauntain {

    private String name;
    private String countryName;
    private int height;

    public Mauntain() {
    }

    public Mauntain(String name, String countryName, int height) {
        this.name = name;
        this.countryName = countryName;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mauntain{" +
                "name='" + name + '\'' +
                ", countryName='" + countryName + '\'' +
                ", height=" + height +
                '}';
    }
}
