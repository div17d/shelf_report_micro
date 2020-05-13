package com.capgemini.go.shelf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.go.shelf.exception.ReportNotFoundException;
import com.capgemini.go.shelf.service.ShelfService;
import com.capgemini.go.shelf.service.ShelfServiceImpl;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api")
public class ShelfController {
	
	@Autowired
	private ShelfService shelfService = new ShelfServiceImpl();

	
	@GetMapping("/viewMonthlyReport/{userID}/{month}/year/{year}")
	public HashMap<String, String> getMontlyReport(@PathVariable("userID") String userID, @PathVariable("month") int month, @PathVariable("year") int year)
	 throws ReportNotFoundException {
		return shelfService.getMonthly(userID, month, year);
	}
	
	@GetMapping("/viewYearlyReport/{userID}/year/{year}")
	public HashMap<String, String> getYealryReport(@PathVariable("userID") String userID, @PathVariable("year") int year)
			 throws ReportNotFoundException {
		return shelfService.getYearly(userID, year);
	}
	
	@GetMapping("/viewQuarterlyReport/{userID}/quarter/{quarter}/year/{year}")
	public HashMap<String, String> getQuartlyReport(@PathVariable("userID") String userID,@PathVariable("quarter") String quarter, @PathVariable("year") int year)
			 throws ReportNotFoundException {
		return shelfService.getQuarterly(userID, quarter , year);
	}
	
	@GetMapping("/viewRetailer")
	public Set<String> getAllRetailer() {
		return shelfService.viewAllRetailer();
	}
	
	@GetMapping("/saleYear")
	public Set<Integer> getSaleYear(){
		return shelfService.saleYear();
		}


}

