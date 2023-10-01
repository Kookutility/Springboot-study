package com.example.logyexample.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Members")  // 테이블 이름이 "Members"로 지정되어 있으므로 @Table 어노테이션을 사용하여 지정합니다.
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(name = "user_id", nullable = false, unique = true)  // 컬럼 이름이 "user_id"로 지정되어 있으므로 @Column 어노테이션을 사용하여 지정합니다.
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;
}