package com.yordyo.carownerservice.owner.controller.impl;

import java.util.List;

import com.yordyo.carownerservice.owner.controller.IOwnerController;
import com.yordyo.carownerservice.owner.dto.OwnerDTO;
import com.yordyo.carownerservice.owner.service.IOwnerService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OwnerController implements IOwnerController {
  private final IOwnerService ownerService;

  public OwnerController(IOwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @Override
  public List<OwnerDTO> getAllOwners() {
    return ownerService.getAllOwners();
  }
}
