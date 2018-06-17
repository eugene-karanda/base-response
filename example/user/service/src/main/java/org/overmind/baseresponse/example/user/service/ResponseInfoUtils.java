package org.overmind.baseresponse.example.user.service;

import org.overmind.baseresponse.ResponseInfo;

final class ResponseInfoUtils {

    static <T> ResponseInfo internal() {
        return ResponseInfo.of(500, " Internal Error");
    }
}
