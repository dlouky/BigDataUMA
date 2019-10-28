package org.uma.mbd.mdNotas.notas;

import java.util.List;

public class MediaAritmetica implements CalculoMedia {

	@Override
	public double calcular(List<Alumno> als) throws AlumnoException{
		if(als.size() == 0) {
			throw new AlumnoException("No hay alumnos para el cálculo de MediaAritmetica");
		}
		double sum = 0;
		for(Alumno alumno : als) {
			sum += alumno.getCalificacion();
		}
		return sum/als.size();
	}
}
