package com.art.demoOne.service.user;

import com.art.demoOne.model.MyUser;

import java.util.List;

public interface UserService {
    List<MyUser> findAll();
    void  save(MyUser user);
    MyUser getById(Long id);
    void deleteById(Long id);
    void delete(Long id);

}
