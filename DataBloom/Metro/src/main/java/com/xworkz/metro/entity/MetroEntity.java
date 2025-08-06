package com.xworkz.metro.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "metro_info")
        @NamedQuery(name = "findMetroByName", query = "SELECT m FROM MetroEntity m WHERE m.metroName = :name")
        @NamedQuery(name = "findMetroByOperator", query = "SELECT m FROM MetroEntity m WHERE m.operator = :operator")
        @NamedQuery(name = "findMetroByTotalRoutes", query = "SELECT m FROM MetroEntity m WHERE m.totalRoutes = :totalRoutes")
        @NamedQuery(name = "findAllMetros", query = "SELECT m FROM MetroEntity m")
        @NamedQuery(name = "updateOperatorById",
                query = "UPDATE MetroEntity m SET m.operator = :operator WHERE m.metroId = :metroId")
        @NamedQuery(name = "updateTotalRoutesAndOperatorByName",
                query = "UPDATE MetroEntity m SET m.totalRoutes = :totalRoutes, m.operator = :operator WHERE m.metroName = :metroName")
        @NamedQuery(name = "updateMetroNameByOperatorAndRoutes",
                query = "UPDATE MetroEntity m SET m.metroName = :metroName WHERE m.operator = :operator AND m.totalRoutes = :totalRoutes")
        @NamedQuery(name = "findAllMetroIds", query = "select m.metroId from MetroEntity m")
        @NamedQuery(name = "findAllMetroNames", query = "select m.metroName from MetroEntity m")
        @NamedQuery(name = "findAllOperators", query = "select m.operator from MetroEntity m")
        @NamedQuery(name = "findAllTotalRoutes", query = "select m.totalRoutes from MetroEntity m")
        @NamedQuery(name = "findAllMetroNameAndOperator", query = "select m.metroName, m.operator from MetroEntity m")
        @NamedQuery(name = "findByAllOperatorAndTotalRoutesAndMetroName",
                query = "select m.operator, m.totalRoutes, m.metroName from MetroEntity m ")

public class MetroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "metro_id")
    private Integer metroId;

    @Column(name = "metro_name")
    private String metroName;

    @Column(name = "operator")
    private String operator;

    @Column(name = "total_routes")
    private Integer totalRoutes;

}
