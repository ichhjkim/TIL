package com.template.pattern.speed;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeedRepository extends JpaRepository<Speed, String> {

    @Query(value = "select 'T' as id , expire_date, reg_date, case when(s.grade_seq is not null) then 'Y' else 'N' end as grade_seq, case when(s.star_seq is not null) then 'Y' else 'N' end as star_seq from speed s order by id limit 50000", nativeQuery = true)
    List<Speed> findCustom();
}
