package org.uma.mbd.mdNotas.notas;

import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class MediaSinExtremos implements CalculoMedia{
	private double min;
	private double max;
	
	public MediaSinExtremos(double min, double max){
		this.min = min;
		this.max = max;
	}

	@Override
	public double calcular(List<Alumno> als) throws AlumnoException{
		if(als.size() == 0) {
			throw new AlumnoException("No hay alumnos para el cálculo de MediaSinExtremos.");
		}
		double sum = 0;
		int n = 0;
		for(Alumno alumno : als) {
			if( (alumno.getCalificacion() >= min) && (alumno.getCalificacion() <= max) ) {
				sum+=alumno.getCalificacion();
				n++;
			}
		}
		return sum/n;
	}
}
