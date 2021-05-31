package com.art.demo_1.repository;

import com.art.demo_1.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <MyUser, Long> {

}
