package com.yordyo.carownerservice.owner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

import com.yordyo.carownerservice.car.entity.Car;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "OWNER")
@Setter
@Getter
@ToString
public class Owner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column
  private String firstName;

  @Column
  private String lastName;

  @Column
  private Date created;

  @OneToMany(mappedBy = "owner")
  private List<Car> cars;
}
