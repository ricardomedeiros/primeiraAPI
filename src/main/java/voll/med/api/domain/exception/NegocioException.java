package voll.med.api.domain.exception;

import java.io.Serial;

public class NegocioException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = -629797664725598546L;

    public NegocioException(String mensagemErro) {
        super(mensagemErro);
    }
}
