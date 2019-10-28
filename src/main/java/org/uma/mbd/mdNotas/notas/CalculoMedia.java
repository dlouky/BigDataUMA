package org.uma.mbd.mdNotas.notas;

import java.util.List;

public interface CalculoMedia {
	double calcular(List<Alumno> als) throws AlumnoException;
}
