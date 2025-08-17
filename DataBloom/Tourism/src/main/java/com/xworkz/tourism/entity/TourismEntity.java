package com.xworkz.tourism.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "tourism_details")
@NamedQuery(name = "fetchAll",query = "select t from TourismEntity t")
@NamedQuery(name = "updateTourism", query = "update TourismEntity t set t.destination=: destination, " +
        "t.startPoint=: startPoint, t.packagePrice=: packagePrice, t.vehicle=: vehicle, t.vehicleNumber=: vehicleNumber," +
        "t.noOfPeople=: noOfPeople, t.startDate=: startDate, t.endDate=:endDate where t.tourID=: tourID")
@NamedQuery(name = "deleteById", query = "delete from TourismEntity t where t.tourID=: tourID")
public class TourismEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "tour_id")
        private Integer tourID;

        @Column(name = "tour_destination")
        private String destination;

        @Column(name = "tour_start_point")
        private String startPoint;

        @Column(name = "package_price")
        private Double packagePrice;

        @Column(name = "vehicle")
        private String vehicle;

        @Column(name = "vehicle_number")
        private String vehicleNumber;

        @Column(name = "no_of_people")
        private Integer noOfPeople;

        @Column(name = "start_date")
        private String startDate;

        @Column(name = "end_date")
        private String endDate;
}
