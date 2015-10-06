package com.san.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class EmailFromRecipient{
	
	private String enronEmailFrom;
	
	public EmailFromRecipient(String enronEmailFrom){
		this.enronEmailFrom = enronEmailFrom;
	}
	@Override
    public String toString() {
        return String.format("EmailQuery Query Details[enronEmailFrom='%s']", enronEmailFrom);
    }
}
