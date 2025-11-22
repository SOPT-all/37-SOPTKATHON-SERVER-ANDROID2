package com.soptkathonserverandroid2.domain.user.entity;

import com.soptkathonserverandroid2.domain.user.entity.enums.College;
import com.soptkathonserverandroid2.domain.user.entity.enums.Department;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private College college;

    @Enumerated(EnumType.STRING)
    private Department department;

    public User(College college, Department department) {
        this.college = college;
        this.department = department;
    }
}
