package com.usa.fedaral.gov.ssa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.fedaral.gov.ssa.entity.StatesMasterEntity;

@Repository
public interface StatesMasterRepository extends JpaRepository<StatesMasterEntity, Serializable>{
	

}
