package com.usa.fedaral.gov.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.fedaral.gov.entity.UsStatesEntity;
@Repository
public interface  UsStatesRepository extends JpaRepository<UsStatesEntity, Serializable> {

}
