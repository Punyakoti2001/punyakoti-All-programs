package com.example.account.dto;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "account")
@Data
public class AccountsContactInfoDto{
	
List<String> onCallSupport;

Map<String,String> contact;

String message;

}
