package com.portfolio.back.repository;

import com.portfolio.back.model.WorkTimeType;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkTimeTypeRepository extends JpaRepository <WorkTimeType, UUID>{
    
    public List<WorkTimeType> findAllByOrderByNameAscIdAsc();
}
