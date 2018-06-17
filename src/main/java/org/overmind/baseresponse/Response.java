package org.overmind.baseresponse;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Objects;

@JsonDeserialize(using = ResponseDeserializer.class)
public class Response<T> {

    private final ResponseInfo responseInfo;

    private final T payload;

    public static <T> Response<T> of(ResponseInfo responseInfo, T payload) {
        return new Response<>(responseInfo, payload);
    }

    private Response(ResponseInfo responseInfo, T payload) {
        this.responseInfo = responseInfo;
        this.payload = payload;
    }

    @JsonUnwrapped
    public ResponseInfo responseInfo() {
        return responseInfo;
    }

    @JsonUnwrapped
    public T payload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseInfo=" + responseInfo +
                ", payload=" + payload +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response<?> response = (Response<?>) o;
        return Objects.equals(responseInfo, response.responseInfo) &&
                Objects.equals(payload, response.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseInfo, payload);
    }
}
