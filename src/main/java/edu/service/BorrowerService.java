package edu.service;

import edu.dto.BorrowerDao;
import edu.entity.BorrowerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BorrowerService {

    void addBorrower(BorrowerDao borrowerDao);
    BorrowerDao searchBorrowerByMembershipNumber(Integer membershipNumber);

    ResponseEntity<String> deleteBorrowerByMembershipNumber(Integer membershipNumber);

    List<BorrowerEntity> getAllBorrowers();
}
