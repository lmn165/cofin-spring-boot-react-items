package shop.cofin.api.backend.dept.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.cofin.api.backend.common.CommonController;
import shop.cofin.api.backend.dept.domain.Dept;
import shop.cofin.api.backend.dept.domain.DeptDto;
import shop.cofin.api.backend.dept.repository.DeptRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/emp")
public class DeptController implements CommonController<Dept, Long> {

    private DeptRepository deptRepository;

    @GetMapping("/find-employees-by-dept-no/{count}")
    public ResponseEntity<Optional<List<DeptDto>>> findDeptsByEmpCount(@PathVariable int count){
        return ResponseEntity.ok(deptRepository.findDeptsByEmpCount(count));
    }


    @Override
    public ResponseEntity<List<Dept>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Dept> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<String> save(Dept entity) {
        return null;
    }

    @Override
    public ResponseEntity<Optional<Dept>> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Boolean> existsById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Long> count() {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteById(Long id) {
        return null;
    }
}
