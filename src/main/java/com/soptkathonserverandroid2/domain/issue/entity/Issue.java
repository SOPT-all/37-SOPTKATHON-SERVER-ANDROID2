package com.soptkathonserverandroid2.domain.issue.entity;

import com.soptkathonserverandroid2.domain.issue.entity.enums.Range;
import com.soptkathonserverandroid2.domain.user.entity.User;
import com.soptkathonserverandroid2.domain.user.entity.enums.College;
import com.soptkathonserverandroid2.domain.user.entity.enums.Department;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "issue_range", length = 20)
    private Range range;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "college", length = 50)
    private College college;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "department", length = 50)
    private Department department;

    @CreatedDate
    private LocalDate createdAt;

    private LocalDate expiredAt;

    private int recommendCount;

    private int agreeCount;

    private int disagreeCount;

    @Builder.Default
    private boolean isPassed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder.Default
    private boolean isCouncil = false;

    @ElementCollection
    private List<String> imageUrls;

    public static Issue create(User user, String title, String description, Range range, College college, Department department) {
        Issue issue = new Issue();
        issue.user = user;
        issue.title = title;
        issue.description = description;
        issue.range = range;
        issue.recommendCount = 0;
        issue.agreeCount = 0;
        issue.disagreeCount = 0;
        issue.isPassed = false;
        issue.createdAt = LocalDate.now();
        issue.expiredAt = LocalDate.now().plusDays(21);
        issue.college = college;
        issue.department = department;
        issue.isCouncil = false;
        return issue;
    }

    public void increaseRecommendCount() {
        this.recommendCount++;
        checkAndUpdatePassedStatus();
    }

    private void checkAndUpdatePassedStatus() {
        if (this.recommendCount >= 300) {
            this.isPassed = true;
        }
    }

    public void increaseAgreeCount() {
        this.agreeCount++;
    }

    public void increaseDisagreeCount() {
        this.disagreeCount++;
    }
}
