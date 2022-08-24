package com.yordyo.carownerservice.car.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yordyo.carownerservice.cardata.entity.CarData;
import com.yordyo.carownerservice.owner.entity.Owner;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
