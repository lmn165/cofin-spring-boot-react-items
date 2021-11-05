package shop.cofin.api.backend.emp.domain;

import lombok.Data;

@Data
public class EmpDto {
    private Long deptNo;
    private int empCountPerDept;
    private int salSum;
}
