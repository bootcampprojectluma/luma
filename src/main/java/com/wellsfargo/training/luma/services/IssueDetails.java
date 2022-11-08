package com.wellsfargo.training.luma.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.training.luma.model.Employee;
import com.wellsfargo.training.luma.model.Issue;
import com.wellsfargo.training.luma.repository.IssueRepository;

@Service
public class IssueDetails implements DAO<Issue> {
	
	@Autowired
	private IssueRepository issueRepo;

	@Override
	public Optional<Issue> get(String id) {
		// TODO Auto-generated method stub
		return Optional.of(issueRepo.getReferenceById(id));
	}

	@Override
	public List<Issue> getAll() {
		return issueRepo.findAll();
	}
	
	public int nextIssueId() {
		if (issueRepo.max()!=null) {
			return Integer.valueOf(issueRepo.max())+1;
		}
		else return 1001;
	}
	

	public List<Issue> getByEmployee(Employee employee){
		List<Issue> issueList = new ArrayList<>();
		for (Issue issue: issueRepo.findAll()) {
			if (issue.getEmployee().getEmployeeId().equals(employee.getEmployeeId())) {
				issueList.add(issue);
			}
		}
		return issueList;
	}

	@Override
	public void save(Issue t) {
		// TODO Auto-generated method stub
		issueRepo.save(t);
	}

	@Override
	public void update(Issue t, String[] params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Issue t) {
		// TODO Auto-generated method stub
		
	}

}
