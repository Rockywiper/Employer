package com.employer.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String skillsRequired;
    private int expRequired;
    private Boolean jobStatus;
    private Long employerId;
    private String companyName;
}
