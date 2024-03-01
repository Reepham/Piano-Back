package com.oktav.piano.back.API.EntityModel;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "levels", schema = "oktav")
@IdClass(LevelsEntityPK.class)
public class LevelsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userid", nullable = false, columnDefinition = "char", length = 19)
    private String userid;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "serverid", nullable = false, columnDefinition = "char", length = 19)
    private String serverid;
    @Basic
    @Column(name = "lv", nullable = true)
    private Byte lv;
    @Basic
    @Column(name = "xp", nullable = true)
    private Integer xp;

}
