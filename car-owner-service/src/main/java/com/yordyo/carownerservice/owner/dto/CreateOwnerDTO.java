package com.yordyo.carownerservice.owner.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOwnerDTO {
  @NotEmpty
  @Size(min = 2)
  private String firstName;

  @NotEmpty
  @Size(min = 2)
  private String lastName;
}
