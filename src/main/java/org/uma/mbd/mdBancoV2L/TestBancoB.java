package org.uma.mbd.mdBancoV2L;

import org.uma.mbd.mdBancoV2L.banco.Banco;

import java.util.List;

public class TestBancoB {
	public static void main(String[] args) {
		
		Banco b = new Banco("TubbiesBank");
		int nPo = b.abrirCuentaVip("Po", 500, 300);
		int nDixy = b.abrirCuenta("Dixy", 500);	
		int nTinkyWinky = b.abrirCuentaVip("Tinky Winky", 500,100);
		int nLala = b.abrirCuenta("Lala", 500);
		System.out.println(b);
		b.ingreso(nPo, 100);
		b.debito(nDixy, 100);
		b.transferencia(nTinkyWinky, nLala, 100);
		System.out.println(b);
		b.cerrarCuenta(nPo);
		b.ingreso(nDixy,200);
		System.out.println(b);
		
		/// Abre tres cuentas nuevas con los titulares proporcionados
		/// en el array nombres
		
		List<String> nombres= List.of("Dora", "Botas", "Pedro");
		List<Integer> cuentas = b.abrirCuentas(nombres);
		System.out.println (b);
		System.out.println(cuentas);
	
		/// Cierra las tres cuentas abiertas

		b.cerrarCuentas(cuentas);
		System.out.println (b);
		
		/// Hace un cierre del ejercicio de las cuentas que hay en 
		/// en el banco b

		b.cierreEjercicio();
		System.out.println (b);
		
		
		List<Integer> nCuentas = List.of(nDixy, nDixy);
		b.cerrarCuentas(nCuentas); //va a tirar Exception ya que se quiere cerrar dos veces la cuenta nDixy
		System.out.println (b);		
		
	}
}


