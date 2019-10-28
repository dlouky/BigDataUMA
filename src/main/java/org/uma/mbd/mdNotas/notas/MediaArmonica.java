package org.uma.mbd.mdNotas.notas;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class MediaArmonica implements CalculoMedia{

	@Override
	public double calcular(List<Alumno> als) throws AlumnoException {
		if(als.size() == 0) {
			throw new AlumnoException("No hay alumnos para el cálculo de MediaArmonica");
		}
		double sum = 0;
		int k = 0;
		for(Alumno alumno : als) {
			if(alumno.getCalificacion() > 0) {
				k++;
				sum += 1/alumno.getCalificacion();
			}
		}
		if(k==0) {
			throw new AlumnoException("No hay alumnos con notas mayores a 0 para el cálculo de MediaArmonica.");
		}
		return k/sum;
	}
}
