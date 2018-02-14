package com.whirlpool.whirlpoolBackend.dao;

import com.whirlpool.whirlpoolBackend.model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StepRepository extends JpaRepository<Step, Long> {

    List<Step> findAllByOrderByOrderPositionAsc();
}
