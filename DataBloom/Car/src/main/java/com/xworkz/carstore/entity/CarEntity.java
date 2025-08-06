package com.xworkz.carstore.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "car_info")
@NamedQueries({
        @NamedQuery(name = "CarEntity.findByMake", query = "SELECT c FROM CarEntity c WHERE c.make = :make"),
        @NamedQuery(name = "CarEntity.findByModel", query = "SELECT c FROM CarEntity c WHERE c.model = :model"),
        @NamedQuery(name = "CarEntity.findByYear", query = "SELECT c FROM CarEntity c WHERE c.year = :year"),
        @NamedQuery(name = "CarEntity.findByPrice", query = "SELECT c FROM CarEntity c WHERE c.price = :price"),
        @NamedQuery(name = "CarEntity.findAll", query = "SELECT c FROM CarEntity c"),

        @NamedQuery(name = "CarEntity.updatePriceById",
                query = "UPDATE CarEntity c SET c.price = :price WHERE c.carId = :carId"),
        @NamedQuery(name = "CarEntity.updateModelAndYearByMake",
                query = "UPDATE CarEntity c SET c.model = :model, c.year = :year WHERE c.make = :make"),
        @NamedQuery(name = "CarEntity.updateMakeByModelAndPrice",
                query = "UPDATE CarEntity c SET c.make = :make WHERE c.model = :model AND c.price = :price")
})
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Integer carId;

    @Column(name = "car_make")
    private String make;

    @Column(name = "car_model")
    private String model;

    @Column(name = "car_year")
    private Integer year;

    @Column(name = "car_price")
    private Double price;

}
