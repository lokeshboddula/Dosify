package com.example.Dosify.repository;

import com.example.Dosify.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmailId(String emailId);

    public User findByMobNo(String mobNo);

    @Query(value = "select * from user u where u.is_dose1_taken = false AND u.is_dose2_taken = false", nativeQuery = true)
    List<User> allUsersWithNoDoses();
}
