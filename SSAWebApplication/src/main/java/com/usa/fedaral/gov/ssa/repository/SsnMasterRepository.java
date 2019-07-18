package com.usa.fedaral.gov.ssa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.fedaral.gov.ssa.entity.SsnMasterEntity;

/**  
 * this interface is for implementing database operations 
 * @author Abdul
 *
 */
@Repository
public interface SsnMasterRepository extends JpaRepository<SsnMasterEntity, Serializable>{
	
	

}
