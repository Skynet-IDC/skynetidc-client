package com.skynetidc.repository;

import com.skynetidc.model.OperatingSystem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperatingSystemRepository extends BaseRepository<OperatingSystem, Long> {

	Optional<List<OperatingSystem>> findByCode(String code);

}
