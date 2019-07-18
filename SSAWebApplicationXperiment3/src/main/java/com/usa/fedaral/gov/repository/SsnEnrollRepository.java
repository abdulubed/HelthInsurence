package com.usa.fedaral.gov.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.fedaral.gov.entity.SsnEntity;
@Repository
public interface  SsnEnrollRepository extends JpaRepository<SsnEntity, Serializable> {

}
