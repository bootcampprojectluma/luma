package com.wellsfargo.training.luma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wellsfargo.training.luma.model.Employee;
import com.wellsfargo.training.luma.model.Issue;

@Repository
public interface IssueRepository extends JpaRepository<Issue, String>{
	
	public List<Issue> findByEmployee(Employee employee);
	
	@Query(value = "SELECT max(issueId) FROM Issue")
	public String max();
	
}
