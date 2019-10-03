package com.motus.emotion.repository;

import com.motus.emotion.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query(value = "SELECT * FROM location WHERE user_id = ?1", nativeQuery = true)
    List<Location> findByUser(Long userId);

}
