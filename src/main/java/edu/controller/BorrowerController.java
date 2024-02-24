package edu.controller;

import edu.dto.BorrowerDao;
import edu.entity.BorrowerEntity;
import edu.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrower")
@RequiredArgsConstructor
public class BorrowerController {

    final BorrowerService borrowerService;
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBorrower(@RequestBody BorrowerDao borrowerDao){
        borrowerService.addBorrower(borrowerDao);
    }
    @GetMapping("/search/{membershipNumber}")
    public BorrowerDao searchBorrowerByMembershipNumber(@PathVariable Integer membershipNumber){
        return borrowerService.searchBorrowerByMembershipNumber(membershipNumber);
    }
    @PostMapping("/delete/{membershipNumber}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> deleteBorrowerByMembershipNumber(@PathVariable Integer membershipNumber){
        return borrowerService.deleteBorrowerByMembershipNumber(membershipNumber);
    }
    @GetMapping("/all")
    public List<BorrowerEntity> getAllBorrowers(){
        return borrowerService.getAllBorrowers();
    }

}
