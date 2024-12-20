package com.trial.api;

import com.trial.dtos.BalanceDTO;
import com.trial.entities.Accounts;
import com.trial.entities.Beneficiaries;
import com.trial.entities.Transactions;
import com.trial.services.AccountsService;
import com.trial.services.BeneficiariesService;
import com.trial.services.TransactionsService;
import com.trial.utilities.ResponseUtility;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
@Path("/trial/bank")
public class BankResource {

	@Autowired
	ResponseUtility responseUtility;

	@Autowired
	BeneficiariesService beneficiariesService;

	@Autowired
	AccountsService accountsService;

	@Autowired
	TransactionsService transactionsService;

	@GET
	@Path("beneficiary-details/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBeneficiaryDetails(@PathParam("id") int id) {
		log.info("Retrieving beneficiary details for id {}", id);
		Beneficiaries beneficiary = beneficiariesService.getBeneficiaryDetails(id).orElse(null);
		log.info("Beneficiary details for id {} is {}", id, beneficiary);
		return responseUtility.okOrEmpty(beneficiary);
	}

	@GET
	@Path("accounts-for-beneficiary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAccountsForBeneficiary(@PathParam("id") int id) {
		log.info("Retrieving accounts of beneficiary with id {}", id);
		List<Accounts> accounts = accountsService.getAccountsOfBeneficiary(id);
		log.info("Accounts of beneficiary with id {} are {}", id, accounts);
		return Response.ok(accounts).build();
	}

	@GET
	@Path("transactions-for-beneficiary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTransactionsForBeneficiary(@PathParam("id") int id) {
		log.info("Retrieving transactions of beneficiary with id {}", id);
		List<Transactions> transactions = transactionsService.getTransactionsOfBeneficiary(id);
		log.info("Transactions of beneficiary with id {} are {}", id, transactions);
		return Response.ok(transactions).build();
	}

	@GET
	@Path("all-accounts-balance-for-beneficiary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAccountsBalanceForBeneficiary(@PathParam("id") int id) {
		log.info("Retrieving all accounts balance of beneficiary with id {}", id);
		List<BalanceDTO> accountBalances = transactionsService.getAllAccountsBalanceForBeneficiary(id);
		log.info("Accounts balance of beneficiary with id {} are {}", id, accountBalances);
		return Response.ok(accountBalances).build();
	}

	@GET
	@Path("largest-withdrawal-last-month-for-beneficiary/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLargestWithdrawalForLastMonthForBeneficiary(@PathParam("id") int id) {
		log.info("Retrieving largest withdrawal for last month of beneficiary with id {}", id);
		Transactions largestTransaction = transactionsService.getLargestWithdrawalLastMonthForBeneficiary(id).orElse(null);
		log.info("Largest withdrawal for last month of beneficiary with id {} is {}", id, largestTransaction);
		return responseUtility.okOrEmpty(largestTransaction);
	}
}