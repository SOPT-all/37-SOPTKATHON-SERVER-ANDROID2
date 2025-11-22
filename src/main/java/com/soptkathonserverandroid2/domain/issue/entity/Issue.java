package com.soptkathonserverandroid2.domain.issue.entity;

import com.soptkathonserverandroid2.domain.issue.entity.enums.Range;
import com.soptkathonserverandroid2.domain.user.entity.enums.College;
import com.soptkathonserverandroid2.domain.user.entity.enums.Department;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Range range;

    @CreatedDate
    private LocalDate createdAt;

    private LocalDate expiredAt;

    private int recommendCount;

    private int agreeCount;

    private int disagreeCount;

    @Builder
    public Issue(String title, String description, Range range, LocalDate createdAt, LocalDate expiredAt, int recommendCount, int agreeCount, int disagreeCount) {
        this.title = title;
        this.description = description;
        this.range = range;
        this.createdAt = createdAt;
        this.expiredAt = expiredAt;
        this.recommendCount = recommendCount;
        this.agreeCount = agreeCount;
        this.disagreeCount = disagreeCount;
    }
}