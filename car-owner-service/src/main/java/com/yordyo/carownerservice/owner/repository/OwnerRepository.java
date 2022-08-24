package com.yordyo.carownerservice.owner.repository;

import com.yordyo.carownerservice.owner.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
