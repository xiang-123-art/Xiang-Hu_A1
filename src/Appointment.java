import java.util.Objects;

public class Appointment {

    private String patientName;
    private String patientMobile;

    private String timeSlot;

    private HealthProfessional attendingDoctor;


    public Appointment() {
        this.patientName = "Unknown Patient";
        this.patientMobile = "Mobile Number Not Provided";
        this.timeSlot = "Time Slot Not Specified";
        this.attendingDoctor = new HealthProfessional();
    }


    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional attendingDoctor) {
        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.attendingDoctor = attendingDoctor;
    }


    public void printAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Appointment Time Slot: " + timeSlot);
        System.out.println("Attending Health Professional Info:");
        attendingDoctor.printDetails();
    }


    public String getPatientMobile() {
        return patientMobile;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(patientMobile, that.patientMobile) && Objects.equals(timeSlot, that.timeSlot);
    }
}