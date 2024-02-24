package edu.repository;

import edu.entity.BorrowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowerRepository extends JpaRepository<BorrowerEntity, Integer> {

}
