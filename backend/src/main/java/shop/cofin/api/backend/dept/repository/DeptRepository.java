package shop.cofin.api.backend.dept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import shop.cofin.api.backend.dept.domain.DeptInfo;
import shop.cofin.api.backend.emp.domain.Emp;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeptRepository extends JpaRepository<Emp, Long> {
    @Query(value = "select (select dname from dept where dept.dept_no = emp.dept_no) as deptName,\n" +
            "       dept_no as deptNo, count(*) as empCountPerDept, sum(sal) as salSum\n" +
            "from emp\n" +
            "group by dept_no\n" +
            "having count(dept_no) > :count", nativeQuery = true)
    Optional<List<DeptInfo>> findEmployeesByDeptNo(@Param("count") int empCountPerDept);

    @Query(value = "select dept_no as deptNo,\n" +
            "       (select dname from dept where dept.dept_no = emp.dept_no) as deptName,\n" +
            "       count(emp_no) as empCountPerDept\n" +
            "from emp\n" +
            "group by dept_no\n" +
            "having count(dept_no) = (select count(dept_no) from emp group by dept_no order by count(*) desc limit 1)", nativeQuery = true)
    List<DeptInfo> findDeptWhichHasMaxEmpCount();
}