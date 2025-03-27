/**
 * @author Sergio Flores
 * @version 1.0
 */

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entidades.Reserva;

public class SistemaReservasDeportivas {

	/**
	 * Atributos de clase
	 */
    private List<Reserva> reservas;
    GestorIluminacion data = new GestorIluminacion();
	static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     * Crea un array dinamico que se encarga de almacenar las reservas aceptadas, 
     * ademas de un array con valores booleanos de tamaño igual al maximo de pistas
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        data.iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Este metodo recibe como parametros el ID de la pista, Fecha y la duracion de las reserva
     * @param idPista
     * @param fecha
     * @param duracion
     * @return true si todos los parametros introducidos son correctos, false si no es asi o la pista ya esta reservada
     */
    public boolean reservarPista(Reserva reserva) {
        if (reserva.getIdPista() < 0 || reserva.getIdPista() >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == reserva.getIdPista() && esFechaDisponible(reserva.getFecha(), r)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(reserva);
        return true;
    }

    /**
     * Este metodo realiza la cancelacion de una reserva, accede a ella y la elimina
     * @param idReserva
     * @return true si la reserva fue eliminada correctamente, false si la reserva no existe
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }
    /**
     * Este metodo recibe como parametros id de pista, fecha de la reserva y por cuanto tiempo se ha reservado
     * @param idPista
     * @param fecha
     * @param hora
     * @return true si la pista esta disponible en la fecha y hora recibido con los parametros,
     * false si el ID no existe o ya esta reservada en la fecha y hora recibido con los parametros.
     */
    public boolean verificarDisponibilidad(int idPista, LocalDateTime fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && esFechaDisponible(fecha, r)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }

	private boolean esFechaDisponible(LocalDateTime fecha, Reserva r) {
		return r.getFecha().equals(fecha);
	}
    
    
}