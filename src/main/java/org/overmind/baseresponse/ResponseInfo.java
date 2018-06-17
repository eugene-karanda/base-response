package org.overmind.baseresponse;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ResponseInfo {

    private final int code;

    private final String description;

    @JsonCreator
    public static ResponseInfo of(
            @JsonProperty("code") int code,
            @JsonProperty("description") String description
    ) {
        return new ResponseInfo(code, description);
    }

    private ResponseInfo(
            int code,
            String description
    ) {
        this.code = code;
        this.description = description;
    }

    @JsonProperty("code")
    public int code() {
        return code;
    }

    @JsonProperty("description")
    public String description() {
        return description;
    }

    @Override
    public String toString() {
        return "ResponseInfo{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponseInfo that = (ResponseInfo) o;
        return code == that.code &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, description);
    }
}
