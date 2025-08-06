package com.xworkz.redbus.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "redbus_info")
@NamedQuery(name = "getByBusName", query = "select b from RedBusEntity b where b.busName = :name")
@NamedQuery(name = "getByPassengerName", query = "select p from RedBusEntity p where p.passengerName = :passenger_name")
@NamedQuery(name = "getByPassengerAge", query = "select a from RedBusEntity a where a.passengerAge = :passenger_age")
@NamedQuery(name = "getByContact", query = "select c from RedBusEntity c where c.contact = :contact")
@NamedQuery(name = "getBySeatNo", query = "select s from RedBusEntity s where s.seatNo = :seat_no")
@NamedQuery(name = "getByAllRedbusEntity", query = "select r from RedBusEntity r")

@NamedQuery(name = "updatePassengerNameByBusIdAndSeatNo",
        query = "update RedBusEntity r set r.passengerName = :passengerName where r.busId = :busId and r.seatNo = :seatNo")

@NamedQuery(name = "updatePassengerAgeByBusIdAndPassengerName",
        query = "update RedBusEntity r set r.passengerAge = :passengerAge where r.busId = :busId and r.passengerName = :passengerName")

@NamedQuery(name = "updateContactByBusIdAndPassengerAge",
        query = "update RedBusEntity r set r.contact = :contact where r.busId = :busId and r.passengerAge = :passengerAge")
public class RedBusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "redbus_id")
    private Integer busId;

    @Column(name = "redbus_busname")
    private String busName;

    @Column(name = "redbus_passengername")
    private String passengerName;

    @Column(name = "redbus_passenger_age")
    private Integer passengerAge;

    @Column(name = "redbus_contact")
    private Long contact;

    @Column(name = "redbus_seat_no")
    private Integer seatNo;
}
