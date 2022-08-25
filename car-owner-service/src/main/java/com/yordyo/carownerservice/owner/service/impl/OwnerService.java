package com.yordyo.carownerservice.owner.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.yordyo.carownerservice.owner.dto.CreateOwnerDTO;
import com.yordyo.carownerservice.owner.dto.OwnerDTO;
import com.yordyo.carownerservice.owner.entity.Owner;
import com.yordyo.carownerservice.owner.repository.OwnerRepository;
import com.yordyo.carownerservice.owner.service.IOwnerService;
import com.yordyo.carownerservice.shared.utils.DTOConverters;
import org.springframework.stereotype.Service;

@Service
public class OwnerService implements IOwnerService {
  private final OwnerRepository ownerRepository;

  public OwnerService(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public List<OwnerDTO> getAllOwnersData() {
    List<Owner> owners = new ArrayList<>();

    ownerRepository.findAll().forEach(owners::add);
    if (!owners.isEmpty()) {
      return owners.stream()
          .map(owner -> DTOConverters.mapToDto(owner, true))
          .collect(Collectors.toList());
    }

    return Collections.emptyList();
  }

  @Override
  public List<OwnerDTO> getOwnerList() {
    List<Owner> owners = new ArrayList<>();

    ownerRepository.findAll().forEach(owners::add);
    if (!owners.isEmpty()) {
      return owners.stream()
          .map(owner -> DTOConverters.mapToDto(owner, false))
          .collect(Collectors.toList());
    }

    return Collections.emptyList();
  }

  @Override
  public OwnerDTO getOwner(Long id) {
    Optional<Owner> owner = ownerRepository.findById(id);
    return owner.map(o -> DTOConverters.mapToDto(o, true)).orElse(null);
  }

  @Override
  public void deleteOwner(Long id) {
    ownerRepository.deleteById(id);
  }

  @Override
  public OwnerDTO createOwner(CreateOwnerDTO ownerDTO) {
    Owner owner = new Owner();
    owner.setFirstName(ownerDTO.getFirstName());
    owner.setFirstName(ownerDTO.getLastName());
    owner.setCreated(Calendar.getInstance().getTime());

    return DTOConverters.mapToDto(ownerRepository.save(owner), false);
  }
}
