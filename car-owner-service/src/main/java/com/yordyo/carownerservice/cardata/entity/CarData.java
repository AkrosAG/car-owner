package com.yordyo.carownerservice.cardata.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.yordyo.carownerservice.car.entity.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "CAR_DATA")
@Setter
@Getter
@ToString
public class CarData {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private Integer engineSize;

  @Column
  private String type;

  @Column
  private Integer hp;

  @Column
  private Integer seats;

  @Column
  private Integer manufacturedYear;

  @OneToOne
  @JoinColumn(name = "CAR_ID")
  private Car car;
}
