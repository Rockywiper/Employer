package com.employer.service;

import com.employer.entity.Employer;
import com.employer.entity.Job;
import com.employer.repository.EmployerRepository;
import com.employer.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerService {

    @Autowired
    private JobRepository jobRepo;

    @Autowired
    private EmployerRepository empRepo;

    public Job addJob(Job job){
        return jobRepo.save(job);
    }

    public List<Job> getJobByEmpId(Long id){
        List<Job> job = jobRepo.findAll();
        List<Job> list = new ArrayList<>();
        int n = job.size();
        for(int i=0;i<n;i++){
            Job j = job.get(i);
            if(j.getEmployerId()==id){
                list.add(j);
            }
        }
        return list;
    }

    public Job getByJobId(Long id){
        List<Job> job = jobRepo.findAll();
        return job.stream().filter(j -> j.getJobId()==id).findAny().orElse(null);
    }

    public List<Job> getAll(){
        return jobRepo.findAll();
    }

    public String deleteJob(Long id){

         jobRepo.deleteById(id);
         return "deleted";
    }

    //Employer
    public Employer addEmp(Employer emp){
        return empRepo.save(emp);
    }

    public List<Employer> getAllEmp(){
        return empRepo.findAll();
    }

    public Employer getByEmpId(Long id){
        List<Employer> emp = empRepo.findAll();
        return emp.stream().filter(e -> e.getEmployerId()==id).findAny().orElse(null);
    }

    public String deleteEmp(Long id){

        empRepo.deleteById(id);
        List<Job> job = jobRepo.findAll();

        int n = job.size();
        for(int i=0;i<n;i++){
            Job j = job.get(i);
            if(j.getEmployerId()==id){
                jobRepo.deleteById(j.getJobId());
            }
        }
        return "deleted";
    }
}
