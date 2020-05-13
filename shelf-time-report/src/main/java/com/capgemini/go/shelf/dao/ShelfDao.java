package com.capgemini.go.shelf.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.go.shelf.entity.Inventory;


@Repository
public interface ShelfDao extends JpaRepository<Inventory, String>{
	
	
	@Query("SELECT i FROM Inventory i WHERE i.userID=?1")
	List<Inventory> viewOrderedProduct(String userID);
	
	@Query("FROM Inventory")
	List<Inventory> viewAll();
	
	@Query("SELECT year(i.receiveTime) FROM Inventory i")
	List<Integer> viewYear();

}
