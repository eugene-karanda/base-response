package org.overmind.baseresponse;

import org.springframework.web.bind.annotation.ExceptionHandler;

public interface ControlledExceptionHandler {

    @ExceptionHandler(ControlledException.class)
    default Response<?> onException(ControlledException e) {
        processControlledException(e);
        return Response.of(e.getResponseInfo());
    }

    default void processControlledException(ControlledException e) {

    }
}
