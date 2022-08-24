package com.yordyo.carownerservice.owner.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yordyo.carownerservice.car.dto.CarDTO;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OwnerDTO {
  private long id;
  private String firstName;
  private String lastName;
  private Date created;
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<CarDTO> cars;
}

