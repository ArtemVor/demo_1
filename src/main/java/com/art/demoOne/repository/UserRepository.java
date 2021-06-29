package com.art.demoOne.repository;

import com.art.demoOne.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <MyUser, Long> {

}
