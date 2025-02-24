package test;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

public class ContactTest {
	@Test
	public void testContactCreation() {
		Contact contact = new Contact("Jesse", "Moore", "9995555555", "Sparks", "0001");
		assertEquals("Jesse", contact.getFirstName());
		assertEquals("Moore", contact.getLastName());
		assertEquals("9995555555", contact.getPhoneNumber());
		assertEquals("Sparks", contact.getAddress());
		assertEquals("0001", contact.getId());
	}
	
	
	@Test
    public void testInvalidContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Jesse", "Moore", "1234567890", "Somewhere new", null);
        });
    }

    // test invalid contact ID: longer than 10 characters
    @Test
    public void testInvalidContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Jesse", "Moore", "1234567890", "Somewhere new", "12345678901");
        });
    }

    // test invalid first name: null
    @Test
    public void testInvalidFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Moore", "1234567890", "Somewhere new", "0001");
        });
    }

    // test invalid first name: longer than 10 characters
    @Test
    public void testInvalidFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("JohnathonLong", "Moore", "1234567890", "Somewhere new", "0001");
        });
    }

    // test invalid last name: null
    @Test
    public void testInvalidLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Jesse", null, "1234567890", "Somewhere new", "0001");
        });
    }

    // test invalid last name: longer than 10 characters
    @Test
    public void testInvalidLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Jesse", "Doeeeeeeeeee", "1234567890", "Somewhere new", "0001");
        });
    }

    // test invalid phone number: null
    @Test
    public void testInvalidPhoneNumberNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Jesse", "Moore", null, "Somewhere new", "0001");
        });
    }

    // test invalid phone number: not exactly 10 digits
    @Test
    public void testInvalidPhoneNumberLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Jesse", "Moore", "916", "Somewhere new", "0001");
        });
    }

    // test invalid address: null
    @Test
    public void testInvalidAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Jesse", "Moore", "1234567890", null, "0001");
        });
    }

    // test invalid address: longer than 30 characters
    @Test
    public void testInvalidAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("Jesse", "Moore", "1234567890", "It is the 41st Millennium. For more than a hundred centuries the Emperor of Mankind has sat immobile on the Golden Throne of Earth. He is the master of mankind by the will of the gods and master of a million worlds by the might of His inexhaustible armies. He is a rotting carcass writhing invisibly with power from the Dark Age of Technology. He is the Carrion Lord of the vast Imperium of Man for whom a thousand souls are sacrificed every day so that He may never truly die.\r\n" + 
            		"\r\n" + 
            		"Yet even in His deathless state, the Emperor continues His eternal vigilance. Mighty battlefleets cross the daemon-infested miasma of the Warp, the only route between distant stars, their way lit by the Astronomican, the psychic manifestation of the Emperor's will. Vast armies give battle in His name on uncounted worlds. Greatest amongst His soldiers are the Adeptus Astartes, the Space Marines, bio-engineered super-warriors. Their comrades in arms are legion: the Imperial Guard and countless planetary defence forces, the ever-vigilant Inquisition and the Tech-priests of the Adeptus Mechanicus to name only a few. But for all their multitudes, they are barely enough to hold off the ever-present threat to humanity from aliens, heretics, mutants -- and far, far worse.\r\n" + 
            		"\r\n" + 
            		"To be a man in such times is to be one amongst untold billions. It is to live in the cruelest and most bloody regime imaginable. These are the tales of those times. Forget the power of technology and science, for so much has been forgotten, never to be relearned. Forget the promise of progress and understanding, for in the grim dark future there is only war. There is no peace amongst the stars, only an eternity of carnage and slaughter, and the laughter of thirsting gods.", "0001");
        });
    }
}

