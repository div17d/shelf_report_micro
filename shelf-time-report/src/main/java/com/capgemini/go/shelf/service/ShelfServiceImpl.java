package com.capgemini.go.shelf.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.capgemini.go.shelf.dao.ShelfDao;
import com.capgemini.go.shelf.entity.Inventory;
import com.capgemini.go.shelf.exception.ReportNotFoundException;

@Service
public class ShelfServiceImpl implements ShelfService {	
	
	@Autowired
	private ShelfDao shelfDao;
	
	String product;
	LocalDateTime saleDate;
	String status;
	LocalDateTime checkDate;
	List<Inventory> productList = new ArrayList<>();
	LocalDateTime receiveDate;
	
	
	
	@Override
	public HashMap<String, String> getMonthly(String userID, int month, int year)  throws ReportNotFoundException {
		HashMap<String, String> shelfReport = new HashMap<>(); 
		productList= shelfDao.viewOrderedProduct(userID);
		checkDate = LocalDateTime.of(year, month, 1, 00, 00,00).plusMonths(1).minusDays(1);
		if(productList.equals(null)) {
			throw new ReportNotFoundException("We can not fecth the result");
		}
		for(Inventory productValue : productList) {
			String	product = productValue.getProductID();
			saleDate = productValue.getSaleTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			receiveDate = productValue.getReceiveTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			
				if((checkDate.isBefore(saleDate) || saleDate.equals(null)) && receiveDate.isBefore(checkDate))
					status = "In Stock";
				else if(receiveDate.isAfter(checkDate))
					status = "Not added in Shelf";
				else
					status = "Sold Out";
				shelfReport.put(product, status);
		}
		return shelfReport;
	}
	
	
	@Override
	public HashMap<String, String> getYearly(String userID, int year) throws ReportNotFoundException {
		HashMap<String, String> shelfReport = new HashMap<>(); 
		productList= shelfDao.viewOrderedProduct(userID);
		checkDate = LocalDateTime.of(year, 1 , 1, 00, 00,00).plusYears(1).minusDays(1);
		if(productList.equals(null))
			throw new ReportNotFoundException("We can not fecth the result");
		else {
		for(Inventory productValue : productList) {

				product = productValue.getProductID();
				saleDate = productValue.getSaleTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				receiveDate = productValue.getReceiveTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				if((checkDate.isBefore(saleDate) || saleDate.equals(null)) && receiveDate.isBefore(checkDate))
					status = "In Stock";
				else if(receiveDate.isAfter(checkDate))
					status = "Not added in shelf";
				else
					status = "Sold Out";
				shelfReport.put(product,status);
				}
		}
		return shelfReport;
	}
	
	@Override
	public HashMap<String, String> getQuarterly(String userID, String quarter, int year) throws ReportNotFoundException {
		HashMap<String, String> shelfReport = new HashMap<>(); 
		productList= shelfDao.viewOrderedProduct(userID);
		if(quarter.equals("Q1"))
			checkDate = LocalDateTime.of(year, 3 , 1, 00, 00,00).plusMonths(1).minusDays(1);
		else if(quarter.equals("Q2"))
			checkDate = LocalDateTime.of(year, 6 , 1, 00, 00,00).plusMonths(1).minusDays(1);
		else if(quarter.equals("Q3"))
			checkDate = LocalDateTime.of(year, 9 , 1, 00, 00,00).plusMonths(1).minusDays(1);
		else if(quarter.equals("Q4"))
			checkDate = LocalDateTime.of(year, 12 , 1, 00, 00,00).plusMonths(1).minusDays(1);
		if(productList.equals(null))
			throw new ReportNotFoundException("We can not fecth the result");
		else {
		for(Inventory productValue : productList) {
			if(productValue.getUserID().equals(userID)) {
				product = productValue.getProductID();
				saleDate = productValue.getSaleTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				receiveDate = productValue.getReceiveTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
				if((checkDate.isBefore(saleDate) || saleDate.equals(null)) && receiveDate.isBefore(checkDate))
					status = "In Stock";
				else if(receiveDate.isAfter(checkDate))
					status = "Not added in shelf";
				else
					status = "Sold Out";
				shelfReport.put(product, status);
				}
		}
		}
		return shelfReport;
	}
	
	
	//get all retailer
	@Override
	public Set<String> viewAllRetailer() {
		
		List<Inventory> list = shelfDao.viewAll();
		Set<String> resultList = list.stream().map(Inventory::getUserID).collect(Collectors.toSet());
		return resultList;	
	}
	
	@Override
	public Set<Integer> saleYear(){
		List<Integer> year = shelfDao.viewYear();
		Integer start= Collections.min(year);
		Set<Integer> result = new HashSet<>();
		Integer end = LocalDateTime.now().getYear();
		for(Integer i=start; i<=end; i++)
			result.add(i);
		return result;
	}


}
