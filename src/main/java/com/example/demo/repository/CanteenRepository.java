package com.example.demo.repository;

import com.example.demo.entity.canteen.dao.Canteen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CanteenRepository extends JpaRepository<Canteen,Integer> {

    List<Canteen> findByCanteenId(List<String> CanteenId);
}
