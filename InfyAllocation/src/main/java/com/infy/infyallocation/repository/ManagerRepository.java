package com.infy.infyallocation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.infyallocation.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

	List<Manager> findAll();



}
