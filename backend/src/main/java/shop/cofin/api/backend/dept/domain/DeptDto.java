package shop.cofin.api.backend.dept.domain;

import lombok.Data;

@Data
public class DeptDto {
    private Long deptNo;
    private int empCountPerDept;
    private int salSum;
}
