package com.san.model;

import java.util.List;

import lombok.Value;

@Value
public class EmailHeader {
	private String id;
	private List<EmailToRecipient> emailToRecipient;

}
