public class HealthProfessional {

    private int id;
    private String name;
    private String hospital;


    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown Name";
        this.hospital = "Unknown Hospital";
    }


    public HealthProfessional(int id, String name, String hospital) {
        this.id = id;
        this.name = name;
        this.hospital = hospital;
    }


    public void printDetails() {
        System.out.println("=== Health Professional Basic Info ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Affiliated Hospital: " + hospital);
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHospital() {
        return hospital;
    }
}