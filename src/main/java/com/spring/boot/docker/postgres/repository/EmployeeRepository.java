package com.spring.boot.docker.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.docker.postgres.model.Employee;

public interface  EmployeeRepository extends JpaRepository<Employee, Integer>
{

}
