
public class GestorIluminacion {
	public boolean[] iluminacion;

	public GestorIluminacion() {
	}

	/**
	 * Metodo que recibe como parametro un ID de pista y gestiona la iluminacion de la misma
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista
	 * @return true si encuentra el numero de pista, false si el ID es menor a 0 o supera el numero maximo de pistas
	 */
	public boolean encenderLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.MAX_PISTAS) {
	        return false; // ID de pista inválido
	    }
	    iluminacion[idPista] = true;
	    return true;
	}

	/**
	 * Metodo que recibe como parametro un ID de pista y gestiona la iluminacion de la misma
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista
	 * @return true si encuentra el numero de pista, false si el ID es menor a 0 o supera el numero maximo de pistas
	 */
	public boolean apagarLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.MAX_PISTAS) {
	        return false; // ID de pista inválido
	    }
	    iluminacion[idPista] = false;
	    return true;
	}
}