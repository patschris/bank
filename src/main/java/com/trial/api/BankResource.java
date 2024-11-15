package com.trial.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/trial/bank")
public class BankResource {

	@GET
	@Path("beneficiary-details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBeneficiaryDetails(@PathParam("id") int id) {
		log.info("Retrieving beneficiary details for id {}", id);
		return Response.ok().build();
	}

	@GET
	@Path("accounts-for-beneficiary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountsForBeneficiary(@PathParam("id") int id) {
		log.info("Retrieving accounts of beneficiary with id {}", id);
		return Response.ok().build();
	}

	@GET
	@Path("transactions-for-beneficiary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsForBeneficiary(@PathParam("id") int id) {
		log.info("Retrieving transactions of beneficiary with id {}", id);
		return Response.ok().build();
	}

	@GET
	@Path("all-accounts-balance-for-beneficiary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAccountsBalanceForBeneficiary(@PathParam("id") int id) {
		log.info("Retrieving all accounts balance of beneficiary with id {}", id);
		return Response.ok().build();
	}

	@GET
	@Path("largest-withdrawal-last-month-for-beneficiary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLargestWithdrawalForLastMonthForBeneficiary(@PathParam("id") int id) {
		log.info("Retrieving largest withdrawal for last month of beneficiary with id {}", id);
		return Response.ok().build();
	}
}