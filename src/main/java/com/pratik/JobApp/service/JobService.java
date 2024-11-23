package com.pratik.JobApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratik.JobApp.model.JobPost;
import com.pratik.JobApp.repo.JobRepo;

@Service
public class JobService {
	@Autowired
	private JobRepo repo;
	public void addJob(JobPost job) {
		repo.addJobPost(job);
	}
	public List<JobPost> getAllJobs(){
		return repo.returnAllJobPosts();
	}
}
