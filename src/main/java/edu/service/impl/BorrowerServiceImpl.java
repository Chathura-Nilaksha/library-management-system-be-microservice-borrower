package edu.service.impl;

import edu.dto.BorrowerDao;
import edu.entity.BorrowerEntity;
import edu.repository.BorrowerRepository;
import edu.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {

    final BorrowerRepository borrowerRepository;
    ModelMapper modelMapper;

    @Bean
    public void makeModelMapperObject() {
        this.modelMapper = new ModelMapper();
    }
    @Override
    public void addBorrower(BorrowerDao borrowerDao) {
        BorrowerEntity borrowerEntity = modelMapper.map(borrowerDao, BorrowerEntity.class);
        borrowerRepository.save(borrowerEntity);
    }
    @Override
    public BorrowerDao searchBorrowerByMembershipNumber(Integer membershipNumber) {
        Optional<BorrowerEntity> borrowerEntity = borrowerRepository.findById(membershipNumber);
        return modelMapper.map(borrowerEntity, BorrowerDao.class);
    }

    @Override
    public ResponseEntity<String> deleteBorrowerByMembershipNumber(Integer membershipNumber) {
        if(borrowerRepository.existsById(membershipNumber)){
            borrowerRepository.deleteById(membershipNumber);
            return ResponseEntity.ok("Deleted");
        }else{
            return ResponseEntity.ok("Invalid membershipNumber");
        }
    }

    @Override
    public List<BorrowerEntity> getAllBorrowers() {
        return borrowerRepository.findAll();
    }


}
