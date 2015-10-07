
package com.san.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="messages")
public class EmailRecipient {

	@Id private String id;


}