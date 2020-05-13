package com.capgemini.go.shelf.service;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.capgemini.go.shelf.exception.ReportNotFoundException;

public interface ShelfService {
	
	//methods to get the report
	
	HashMap<String, String> getMonthly(String userID, int month, int year) throws ReportNotFoundException;

	HashMap<String, String> getYearly(String userID, int year) throws ReportNotFoundException;

	Set<String> viewAllRetailer();

	Set<Integer> saleYear();

	HashMap<String, String> getQuarterly(String userID, String quarter, int year) throws ReportNotFoundException;
}




