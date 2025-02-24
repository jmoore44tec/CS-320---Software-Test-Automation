package test;
import appointment.Appointment;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	@Test
    void testAppointmentCreation() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("0123456789", futureDate, "Dentist Appointment");
        assertEquals("0123456789", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Dentist Appointment", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "Dentist Appointment"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", futureDate, "Dentist Appointment"));
    }

    @Test
    void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("0123456789", pastDate, "Dentist Appointment"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("0123456789", null, "Dentist Appointment"));
    }

    @Test
    void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("0123456789", futureDate, null));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("0123456789", futureDate, "This description is way too long and should throw an exception"));
    }
}
