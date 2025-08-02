package com.xworkz.train.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name="train_info")
public class TrainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="train_id")
    private int trainId;

    @Column(name="train_name")
    private String trainName;

    @Column(name="train_source")
    private String source;

    @Column(name="train_destination")
    private String destination;

}
