package org.uma.mbd.mdMasterMindL.mastermind;

public class MasterMindException extends RuntimeException {

    public MasterMindException() {
    }

    public MasterMindException(String mensaje) {
        super(mensaje);
    }
}
