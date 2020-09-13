package com.sca.dao.domain.common;

public enum EntityStatusEnum {

	DRAFT(1), 
	SUBMITTED_TO_FEMS_SUCCESSFULLY(2), 
	FAILED_TO_SUBMIT_TO_FEMS(3);
	
	private final int value;

	EntityStatusEnum(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

}
