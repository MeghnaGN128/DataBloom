package com.xworkz.makeupkit.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "makeup_kit_info")
@NamedQueries({
        @NamedQuery(name = "MakeupKitEntity.findByBrand", query = "SELECT m FROM MakeupKitEntity m WHERE m.brand = :brand"),
        @NamedQuery(name = "MakeupKitEntity.findByType", query = "SELECT m FROM MakeupKitEntity m WHERE m.type = :type"),
        @NamedQuery(name = "MakeupKitEntity.findByPrice", query = "SELECT m FROM MakeupKitEntity m WHERE m.price = :price"),
        @NamedQuery(name = "MakeupKitEntity.findAll", query = "SELECT m FROM MakeupKitEntity m"),

        @NamedQuery(name = "MakeupKitEntity.updatePriceById",
                query = "UPDATE MakeupKitEntity m SET m.price = :price WHERE m.makeupKitId = :makeupKitId"),
        @NamedQuery(name = "MakeupKitEntity.updateTypeAndExpiryByBrand",
                query = "UPDATE MakeupKitEntity m SET m.type = :type, m.expiryDate = :expiryDate WHERE m.brand = :brand"),
        @NamedQuery(name = "MakeupKitEntity.updateBrandByTypeAndPrice",
                query = "UPDATE MakeupKitEntity m SET m.brand = :brand WHERE m.type = :type AND m.price = :price")
})
public class MakeupKitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "makeupkit_id")
    private Integer makeupKitId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "type")
    private String type;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "price")
    private Double price;
}
