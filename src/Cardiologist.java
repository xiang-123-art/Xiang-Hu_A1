public class Cardiologist extends HealthProfessional {

    private String subSpecialty;


    public Cardiologist() {
        super();
        this.subSpecialty = "Coronary Disease Treatment";
    }


    public Cardiologist(int id, String name, String hospital, String subSpecialty) {
        super(id, name, hospital);
        this.subSpecialty = subSpecialty;
    }


    @Override
    public void printDetails() {
        System.out.println("[Health Professional Type: Cardiologist]");
        super.printDetails();
        System.out.println("Sub-specialty: " + subSpecialty);
        System.out.println();
    }


    public String getSubSpecialty() {
        return subSpecialty;
    }
}