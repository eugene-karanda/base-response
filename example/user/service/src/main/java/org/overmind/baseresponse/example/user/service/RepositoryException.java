package org.overmind.baseresponse.example.user.service;

import org.overmind.baseresponse.ControlledException;
import org.overmind.baseresponse.ResponseInfo;

public class RepositoryException extends ControlledException {
    public RepositoryException(String message, ResponseInfo responseInfo) {
        super(message, responseInfo);
    }
}
