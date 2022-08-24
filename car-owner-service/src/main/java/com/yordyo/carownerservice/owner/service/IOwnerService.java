package com.yordyo.carownerservice.owner.service;

import java.util.List;

import com.yordyo.carownerservice.owner.dto.OwnerDTO;

public interface IOwnerService {
  List<OwnerDTO> getAllOwners();
}
