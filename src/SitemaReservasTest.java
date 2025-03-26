import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SistemaReservasDeportivasTest {

	static SistemaReservasDeportivas sistemaReservas;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		sistemaReservas = new SistemaReservasDeportivas();

	}
	
	@Test
	void testReservarPista() {

		assertTrue(sistemaReservas.reservarPista(1, "21-03-2025 12:00", 60));
		assertFalse(sistemaReservas.reservarPista(1, "21-03-2025 12:00", 60));
		assertTrue(sistemaReservas.reservarPista(2, "21-03-2025 12:00", 60));
		assertTrue(sistemaReservas.reservarPista(3, "22-03-2025 12:00", 60));
		assertTrue(sistemaReservas.reservarPista(10, "22-03-2025 12:00", 60));
	}

	@Test
	void testCancelarReserva() {
		assertTrue(sistemaReservas.cancelarReserva(1));
	}

	@Test
	void testActivarIluminacion() {
		assertTrue(sistemaReservas.activarIluminacion(1));
		assertTrue(sistemaReservas.activarIluminacion(2));
		assertTrue(sistemaReservas.activarIluminacion(3));
		assertTrue(sistemaReservas.activarIluminacion(10));
	}

	@Test
	void testDesactivarIluminacion() {
		
		assertTrue(sistemaReservas.desactivarIluminacion(4));
		assertFalse(sistemaReservas.desactivarIluminacion(4));
		assertTrue(sistemaReservas.desactivarIluminacion(5));
		assertTrue(sistemaReservas.desactivarIluminacion(6));
		assertTrue(sistemaReservas.desactivarIluminacion(7));
		assertTrue(sistemaReservas.desactivarIluminacion(8));
		assertTrue(sistemaReservas.desactivarIluminacion(9));
	}

	@Test
	void testVerificarDisponibilidad() {

		assertFalse(sistemaReservas.verificarDisponibilidad(2, "21-03-2025", "12:00"));
		assertFalse(sistemaReservas.verificarDisponibilidad(3, "22-03-2025", "12:00"));
		assertFalse(sistemaReservas.verificarDisponibilidad(10, "22-03-2025", "12:00"));
		assertTrue(sistemaReservas.verificarDisponibilidad(4, "21-03-2025", "12:00"));
		assertTrue(sistemaReservas.verificarDisponibilidad(2, "25-03-2025", "12:00"));
		assertTrue(sistemaReservas.verificarDisponibilidad(8, "23-03-2025", "12:00"));
	}
}
