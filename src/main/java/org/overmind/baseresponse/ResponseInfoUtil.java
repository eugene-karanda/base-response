package org.overmind.baseresponse;

final class ResponseInfoUtil {

    public static ResponseInfo ok = ResponseInfo.of(0, "Ok");

    public static ResponseInfo usedCached(String what) {
        return ResponseInfo.of(103, "'" + what + "' returned from cache");
    }

    public static ResponseInfo notFound(String what) {
        return ResponseInfo.of(404, "'" + what + "' not found");
    }

}
