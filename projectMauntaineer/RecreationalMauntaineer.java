package projectMauntaineer;

public class RecreationalMauntaineer extends Mauntaineer{
    private int equipmentWeight;
    private String county;
    private int maxAscentWithoutEquipment;
    private static final int membership = 1000;

    public RecreationalMauntaineer() {
    }

    public RecreationalMauntaineer(int id, String fistName, String lastName, int equipmentWeight, String county, int maxAscentWithoutEquipment) {
        super(id, fistName, lastName);
        this.equipmentWeight = equipmentWeight;
        this.county = county;
        this.maxAscentWithoutEquipment = maxAscentWithoutEquipment;
    }

    public boolean successfulAscent(Mauntain mauntain) {
        return (maxAscentWithoutEquipment - (this.equipmentWeight * 50)) >= mauntain.getHeight();
    }

    public double membershipCalculation() {
        return membership;
    }

    public void print() {
        System.out.println("Recreational mauntaineer, " + super.toString() + ", county: " + this.county);
    }
    
}
