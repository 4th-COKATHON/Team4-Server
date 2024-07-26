package cotato.cokathon.apipayload.handler;

import cotato.cokathon.apipayload.code.BaseCode;
import cotato.cokathon.apipayload.code.status.ErrorStatus;
import cotato.cokathon.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseCode errorCode) {
        super((ErrorStatus) errorCode);
    }
}