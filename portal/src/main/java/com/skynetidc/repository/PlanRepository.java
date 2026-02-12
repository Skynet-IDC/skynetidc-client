package com.skynetidc.repository;

import com.skynetidc.model.Plan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository extends BaseRepository<Plan, Long> {

	@Query(nativeQuery = true, value = "UPDATE tblusers SET password=:password WHERE email=:email")
	Optional<List<Plan>> findByLocation(String email);

}
