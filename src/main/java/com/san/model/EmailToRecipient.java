package com.san.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class EmailToRecipient{
	
	private String enronEmailTo;
	
	public EmailToRecipient(String enronEmailTo){
		this.enronEmailTo = enronEmailTo;
	}
	@Override
    public String toString() {
        return String.format("EmailQuery Query Details[enronEmailTo='%s']", enronEmailTo);
    }
}
