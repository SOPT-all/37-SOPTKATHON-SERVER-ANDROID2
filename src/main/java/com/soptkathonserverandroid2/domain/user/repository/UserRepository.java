package com.soptkathonserverandroid2.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soptkathonserverandroid2.domain.user.entity.User;
import com.soptkathonserverandroid2.domain.user.entity.enums.College;
import com.soptkathonserverandroid2.domain.user.entity.enums.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u.college FROM User u WHERE u.id = :id")
    College findCollegeById(@Param("id") Long id);

    @Query("SELECT u.department FROM User u WHERE u.id = :id")
    Department findDepartmentById(@Param("id") Long id);
}
