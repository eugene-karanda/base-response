package org.overmind.baseresponse;

public final class ResponseUtil {

    public static <T> Response<T> ok(T payload) {
        return Response.of(ResponseInfoUtil.ok, payload);
    }

    public static <T> Response<T> usedCached(T payload, String what) {
        return Response.of(ResponseInfoUtil.usedCached(what), payload);
    }

    public static <T> Response<T> notFound(String what) {
        return Response.of(ResponseInfoUtil.notFound(what), null);
    }
}
