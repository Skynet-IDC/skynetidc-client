package com.skynetidc.repository;

import com.skynetidc.model.Hosting;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostingRepository extends JpaRepository<Hosting, Long> {

	@Query(nativeQuery = true, value = "SELECT t.* FROM portal.tblhosting AS t "
			+ "INNER JOIN tblservers t2 on t2.id = t.server " + "WHERE t.userid = :userid AND t2.`type` in (:types)")
	List<Hosting> findByUserid(@NotNull long userid, @NotNull List<String> types);

}
