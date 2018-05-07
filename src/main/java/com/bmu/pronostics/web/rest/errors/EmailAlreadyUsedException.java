package com.bmu.pronostics.web.rest.errors;

public class EmailAlreadyUsedException extends BadRequestAlertException {

    private static final long serialVersionUID = -1998459789455165762L;

	public EmailAlreadyUsedException() {
        super(ErrorConstants.EMAIL_ALREADY_USED_TYPE, "Email address already in use", "userManagement", "emailexists");
    }
}
