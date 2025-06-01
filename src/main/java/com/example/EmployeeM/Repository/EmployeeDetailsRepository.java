package com.example.EmployeeM.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.EmployeeM.Entity.EmployeeDetails;
@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {
	boolean existsByLoginId(String loginId);
	

}
