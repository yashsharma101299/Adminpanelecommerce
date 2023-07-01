package com.day8.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.day8.model.PurchaseReports;
import com.day8.repository.Purchasereportrepository;
@Service
public class Purchasereportservice {
	@Autowired
	private Purchasereportrepository prr;
	
	public List<PurchaseReports> purchasereportslist()
	{
		List<PurchaseReports> findAll = prr.findAll();
		return findAll;
	}
	
	public void addnewpurchasereport(PurchaseReports purchaseReports) 
	{
		prr.save(purchaseReports);
		
	}
	public void removepurchasereport(int id) 
	{
		prr.deleteById(id);
	}
	public List<PurchaseReports> reportsbydate(String date){
		List<PurchaseReports> findBydate = prr.findBydate(date);
		return findBydate;
	}
	
	public List<PurchaseReports> reportsbyuserid(int id)
	{
		List<PurchaseReports> findByuserId = prr.findByuserId(id);
		return findByuserId;
	}

}
