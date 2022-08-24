package com.yordyo.carownerservice.owner.service;

import java.util.List;

import com.yordyo.carownerservice.owner.dto.CreateOwnerDTO;
import com.yordyo.carownerservice.owner.dto.OwnerDTO;

public interface IOwnerService {
  List<OwnerDTO> getAllOwnersData();

  List<OwnerDTO> getOwnerList();

  OwnerDTO getOwner(Long id);

  void deleteOwner(Long id);

  OwnerDTO createOwner(CreateOwnerDTO owner);
}
