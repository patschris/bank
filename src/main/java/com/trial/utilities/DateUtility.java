package com.trial.utilities;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;

@ApplicationScoped
public class DateUtility {

	public LocalDate getDateBeforeMonth(int monthsBefore) {
		return LocalDate.now().minusMonths(monthsBefore);
	}
}