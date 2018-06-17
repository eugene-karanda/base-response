package org.overmind.baseresponse.example.user.service;

import org.overmind.baseresponse.Response;
import org.overmind.baseresponse.ResponseInfo;

final class Responses {

    static <T> Response<T> ok(T payload) {
        return Response.of(
                ResponseInfo.of(0, "Ok"),
                payload
        );
    }

    static <T> Response<T> usedCached(T payload, String what) {
        return Response.of(
                ResponseInfo.of(103, "'" + what + "' returned from cache"),
                payload
        );
    }

    static <T> Response<T> notFound(String what) {
        return Response.of(
                ResponseInfo.of(404, "'" + what + "' not found"), null
        );
    }
}
