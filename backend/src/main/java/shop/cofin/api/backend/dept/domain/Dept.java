package shop.cofin.api.backend.dept.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.Proxy;
import org.springframework.stereotype.Component;
import shop.cofin.api.backend.emp.domain.Emp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Component
@Table(name = "dept") @Proxy(lazy = false)
public class Dept {
    @Id
    @Column(name = "dept_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptNo;

    @Column(length = 14) @NotNull private String dname;
    @Column(length = 13) @NotNull private String loc;

    @OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
    private List<Emp> empList = new ArrayList<>();
}
