package shop.cofin.api.backend.dept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.cofin.api.backend.dept.domain.DeptDto;
import shop.cofin.api.backend.emp.domain.Emp;
import shop.cofin.api.backend.emp.domain.EmpDto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public interface DeptRepository extends JpaRepository<Emp, Long> {
    @Query(value = "select dept_no deptNo, count(*) empCountPerDept, sum(sal) salSum\n" +
            "from emp\n" +
            "group by dept_no\n" +
            "having count(*) > :count", nativeQuery = true)
    Optional<List<DeptDto>> findDeptsByEmpCount(@Param("count") int empCountPerDept);
}
