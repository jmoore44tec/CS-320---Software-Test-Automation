package appointment;

import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class AppointmentService {
    private final Map<String, Appointment> appointments = new HashMap<>();

    public void addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment already exists or is null.");
        }
        appointments.put(appointment.getAppointmentId(), appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointments.remove(appointmentId);
    }

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }

    public void updateAppointmentDate(String appointmentId, Date newDate) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointment.setAppointmentDate(newDate);
    }

    public void updateAppointmentDescription(String appointmentId, String newDescription) {
        Appointment appointment = appointments.get(appointmentId);
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment ID does not exist.");
        }
        appointment.setDescription(newDescription);
    }
}