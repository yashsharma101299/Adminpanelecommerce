package com.day8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.day8.model.PurchaseReports;

public interface Purchasereportrepository extends JpaRepository<PurchaseReports , Integer> {
 public List<PurchaseReports> findBydate(String date);
 public List<PurchaseReports> findByuserId(int id);
}
