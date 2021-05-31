package com.art.demo_1.service;

import com.art.demo_1.model.MyUser;

import java.util.List;

public interface UserService {
    List<MyUser> findAll();
    void  save(MyUser user);
    MyUser getById(Long id);
    void deleteById(Long id);
    void delete(Long id);

}
