package com.example.aopdemo;

import com.example.aopdemo.dao.AccountDAO;
import com.example.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, TrafficFortuneService trafficFortuneService) {
		return runner -> {
//			demoBeforeAdvise(accountDAO);
//			demoAfterReturningAdvise(accountDAO);
//			demoAfterThrowingAdvise(accountDAO);
//			demoAfterAdvise(accountDAO);
//			demoAroundAdvise(trafficFortuneService);
//			demoAroundAdviseHandleException(trafficFortuneService);
			demoAroundAdviseRethrowException(trafficFortuneService);
		};
	}

	private void demoAroundAdviseRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main program:around advise");
		boolean trip=true;
		System.out.println("Traffic prediction "+trafficFortuneService.getFortune(trip));
		System.out.println("Finished");

	}

	private void demoAroundAdviseHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main program:around advise");
		boolean trip=true;
		System.out.println("Traffic prediction "+trafficFortuneService.getFortune(trip));
		System.out.println("Finished");
	}

	private void demoAroundAdvise(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main program:around advise");
		System.out.println("Traffic prediction "+trafficFortuneService.getFortune());
		System.out.println("Finished");
	}

	private void demoAfterThrowingAdvise(AccountDAO accountDAO) {
		List<Account> theAccounts=null;
		try{
			boolean trip=true;
			theAccounts= accountDAO.findAccounts(trip);
		} catch(Exception exc){
			System.out.println("Main program: caught exception "+exc);
		}
		System.out.println("---------");
		System.out.println(theAccounts);

	}

	private void demoBeforeAdvise(AccountDAO accountDAO) {
		accountDAO.addAccount();
//		accountDAO.addAccount(accountDAO,true);
		//call getter and setter methods
		accountDAO.setName("Bank");
		String name =accountDAO.getName();
		accountDAO.addAccount(accountDAO,true);
	}

	private void demoAfterReturningAdvise(AccountDAO accountDAO) {
		List<Account> theAccounts=accountDAO.findAccounts();
		System.out.println("---------");
		System.out.println(theAccounts);

	}

	private void demoAfterAdvise(AccountDAO accountDAO) {
		List<Account> theAccounts=null;
		try{
			boolean trip=false;
			theAccounts= accountDAO.findAccounts(trip);
		} catch(Exception exc){
			System.out.println("Main program: caught exception "+exc);
		}
		System.out.println("---------");
		System.out.println(theAccounts);


	}

}
