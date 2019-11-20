package com.tech.tests.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.tests.model.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role,Long>{
	
	List<Role> findByRoleNameIn(List<String> roleName);
	Optional<Role> findByRoleName(String roleName);

}
