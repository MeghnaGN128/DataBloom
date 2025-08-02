package com.xworkz.application.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Data
@RequiredArgsConstructor
@Table(name="application_info")
@NamedQuery(name = "findByName", query = "select a from ApplicationEntity a where a.applicationName=:name")
@NamedQuery(name = "findBySize", query = "select s from ApplicationEntity s where s.applicationSize=:size")
@NamedQuery(name = "findByCompany", query = "select c from ApplicationEntity c where c.company=:company")
@NamedQuery(name = "findByUsers", query = "select u from ApplicationEntity u where u.noOfUsers =:users")
@NamedQuery(name = "findByRatings", query = "select r from ApplicationEntity r where r.ratings=:ratings")
@NamedQuery(name = "findByLaunchDate", query = "select d from ApplicationEntity d where d.launchDate=:launchDate")

public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="application_id")
    private Integer applicationId;

    @Column(name="application_name")
    private String applicationName;

    @Column(name="application_size")
    private  String applicationSize;

    @Column(name="application_company")
    private String company;

    @Column(name="application_no_of_users")
    private Integer noOfUsers;

    @Column(name="application_ratings")
    private Float ratings;

    @Column(name="application_launch_date")
    private LocalDate launchDate;
}
