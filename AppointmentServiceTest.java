package test;

import appointment.AppointmentService;
import appointment.Appointment;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import org.junit.jupiter.api.Test;

class AppointmentServiceTest {

	@Test
    void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("0123456789", futureDate, "Dentist Appointment");
        service.addAppointment(appointment);
        assertNotNull(service.getAppointment("0123456789"));
    }

    @Test
    void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("0123456789", futureDate, "Dentist Appointment");
        service.addAppointment(appointment);
        service.deleteAppointment("0123456789");
        assertNull(service.getAppointment("0123456789"));
    }

    @Test
    void testUpdateAppointmentDate() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("0123456789", futureDate, "Dentist Appointment");
        service.addAppointment(appointment);

        Date newDate = new Date(System.currentTimeMillis() + 200000);
        service.updateAppointmentDate("0123456789", newDate);
        assertEquals(newDate, service.getAppointment("0123456789").getAppointmentDate());
    }

    @Test
    void testUpdateAppointmentDescription() {
        AppointmentService service = new AppointmentService();
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("0123456789", futureDate, "Dentist Appointment");
        service.addAppointment(appointment);

        service.updateAppointmentDescription("0123456789", "Updated Description");
        assertEquals("Updated Description", service.getAppointment("0123456789").getDescription());
    }
}