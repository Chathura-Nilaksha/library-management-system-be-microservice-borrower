package edu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class BorrowerDao {
    private String name;
    private String contactNumber;
    private String cityOfLiving;
    private Integer numberOfBooksTakenOutOfTwo;
    private String bookName1;
    private String bookName2;

}
