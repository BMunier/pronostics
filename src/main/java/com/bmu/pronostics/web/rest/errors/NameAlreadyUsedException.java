package com.bmu.pronostics.web.rest.errors;

public class NameAlreadyUsedException extends BadRequestAlertException {

    public NameAlreadyUsedException() {
        super(ErrorConstants.STADE_ALREADY_EXISTS, "Stade already in use", "stadeManagement", "stadeexists");
    }
}