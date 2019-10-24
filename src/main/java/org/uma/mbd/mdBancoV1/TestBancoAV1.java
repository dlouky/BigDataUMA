package org.uma.mbd.mdBancoV1;

import org.uma.mbd.mdBancoV1.banco.Banco;

public class TestBancoAV1 {
	public static void main(String[] args) {
		Banco b = new Banco("TubbiesBank", 5);
		int nPo = b.abrirCuenta("Po", 500);
		int nDixy = b.abrirCuenta("Dixy", 500);
		int nTinkyWinky = b.abrirCuenta("Tinky Winky", 500);
		int nLala = b.abrirCuenta("Lala", 500);
		int nNono = b.abrirCuenta("Nono");
		System.out.println(b);
		b.ingreso(nPo, 100);
		b.ingreso(nNono, 300);
		b.debito(nDixy, 100);
		b.transferencia(nTinkyWinky, nLala, 100);
		System.out.println(b);
		b.cerrarCuenta(nNono);
		b.cerrarCuenta(nPo);
		b.ingreso(nDixy,200);
		System.out.println(b);	
	}
}


// salida:
// TubbiesBank: [[(Po/1001) -> 500.0] [(Dixy/1002) -> 500.0] [(Tinky Winky/1003) -> 500.0] [(Lala/1004) -> 500.0] [(Nono/1005) -> 0.0] ]
// TubbiesBank: [[(Po/1001) -> 600.0] [(Dixy/1002) -> 400.0] [(Tinky Winky/1003) -> 400.0] [(Lala/1004) -> 600.0] [(Nono/1005) -> 300.0] ]
// TubbiesBank: [[(Dixy/1002) -> 600.0] [(Tinky Winky/1003) -> 400.0] [(Lala/1004) -> 600.0] ]
