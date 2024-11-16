package com.trial.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@JsonAutoDetect
public class BalanceDTO {
	private int accountId;

	private BigDecimal balance;
}