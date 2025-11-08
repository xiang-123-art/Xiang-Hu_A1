public class GeneralPractitioner extends HealthProfessional {

    private int maxDailyPatients;


    public GeneralPractitioner() {
        super();
        this.maxDailyPatients = 20;
    }


    public GeneralPractitioner(int id, String name, String hospital, int maxDailyPatients) {

        super(id, name, hospital);
        this.maxDailyPatients = maxDailyPatients;
    }


    @Override
    public void printDetails() {
        System.out.println("[Health Professional Type: General Practitioner]");
        super.printDetails();
        System.out.println("Max Daily Patients: " + maxDailyPatients);
        System.out.println();
    }


    public int getMaxDailyPatients() {
        return maxDailyPatients;
    }
}