package com.yordyo.carownerservice.car.entity;

import com.yordyo.carownerservice.cardata.entity.CarData;
import com.yordyo.carownerservice.owner.entity.Owner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
@Setter
@Getter
@ToString
public class Car {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String manufacturer;

  @Column
  private String model;

  @Column
  private Integer registrationYear;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "OWNER_ID")
  private Owner owner;

  @OneToOne(mappedBy = "car")
  private CarData data;
}
