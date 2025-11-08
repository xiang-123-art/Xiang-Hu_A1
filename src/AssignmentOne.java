import java.util.ArrayList;
import java.util.List;

// Main class: program entry point (integrates Part3 and Part5 functions)
public class AssignmentOne {
    // Static list: store all appointments (globally accessible for all methods)
    private static List<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // Part 3 – Using classes and objects
        System.out.println("==================== Part 3: Health Professional Objects ====================");
        // Create 3 General Practitioners and 2 Cardiologists
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "John Doe", "South Community Hospital", 25);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Jane Smith", "East Community Hospital", 22);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Mike Wilson", "West Community Hospital", 20);
        Cardiologist cardio1 = new Cardiologist(201, "Sarah Lee", "Central City Hospital", "Coronary Intervention");
        Cardiologist cardio2 = new Cardiologist(202, "David Chen", "First City Hospital", "Arrhythmia Treatment");

        // Print details of all health professionals
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        cardio1.printDetails();
        cardio2.printDetails();

        System.out.println("------------------------------");

        // Part 5 – Collection of appointments
        System.out.println("==================== Part 5: Appointment Collection ====================");
        // Create 4 appointments (2 with General Practitioners, 2 with Cardiologists)
        createAppointment("Alice Brown", "13800138001", "08:30", gp1);
        createAppointment("Bob Taylor", "13900139001", "10:15", gp2);
        createAppointment("Charlie Green", "13700137001", "14:00", cardio1);
        createAppointment("Diana White", "13600136001", "15:30", cardio2);

        // Demonstrate: print → cancel → print again
        System.out.println("\n[All Appointments (Before Cancellation)]");
        printExistingAppointments();
        System.out.println("\n[Canceling Appointment (Mobile: 13900139001)]");
        cancelBooking("13900139001");
        System.out.println("\n[All Appointments (After Cancellation)]");
        printExistingAppointments();

        System.out.println("------------------------------");
    }


     /**
     * Create appointment: add to list only if all info is valid
     * Supports polymorphism (accepts any HealthProfessional subclass: GP/Cardiologist)
     * Rejects if any required field is empty/null
     */
    public static void createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Appointment Failed: Patient name cannot be empty!");
            return;
        }
        if (patientMobile == null || patientMobile.trim().isEmpty()) {
            System.out.println("Appointment Failed: Patient mobile cannot be empty!");
            return;
        }
        if (timeSlot == null || timeSlot.trim().isEmpty()) {
            System.out.println("Appointment Failed: Time slot cannot be empty!");
            return;
        }
        if (doctor == null) {
            System.out.println("Appointment Failed: Attending doctor not specified!");
            return;
        }

        appointmentList.add(new Appointment(patientName, patientMobile, timeSlot, doctor));
        System.out.println("Appointment Success! Patient: " + patientName + ", Time: " + timeSlot);
    }

    // Print all appointments; show message if list is empty
    public static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("\n[Appointment " + (i + 1) + "]");
            appointmentList.get(i).printAppointmentDetails();
        }
    }

    // Cancel appointment by patient's mobile; show error if mobile not found
    public static void cancelBooking(String targetMobile) {
        boolean cancelled = false;
        for (int i = 0; i < appointmentList.size(); i++) {
            if (appointmentList.get(i).getPatientMobile().equals(targetMobile)) {
                appointmentList.remove(i);
                cancelled = true;
                break;
            }
        }
        System.out.println(cancelled ?
                "Appointment Cancelled (Mobile: " + targetMobile + ")" :
                "Cancellation Failed: Mobile " + targetMobile + " not found");
    }
}