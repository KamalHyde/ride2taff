package com.example.ride2taff.repository;

import com.example.ride2taff.entity.RoleEntity;
import org.hibernate.cfg.annotations.reflection.internal.JPAXMLOverriddenAnnotationReader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

}
