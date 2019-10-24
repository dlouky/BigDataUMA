package org.uma.mbd.mdBancoV2L.banco;

public class BancoException extends RuntimeException {
    public BancoException() {
        super();
    }

    public BancoException (String msg) {
        super(msg);
    }
}
