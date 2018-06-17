package org.overmind.baseresponse;

public class ControlledException extends RuntimeException {

    private final ResponseInfo responseInfo;

    public ControlledException(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

    public ControlledException(String message, ResponseInfo responseInfo) {
        super(message);
        this.responseInfo = responseInfo;
    }

    public ControlledException(String message, Throwable cause, ResponseInfo responseInfo) {
        super(message, cause);
        this.responseInfo = responseInfo;
    }

    public ControlledException(Throwable cause, ResponseInfo responseInfo) {
        super(cause);
        this.responseInfo = responseInfo;
    }

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }
}
