package com.example.logyexample.repository;
import com.example.logyexample.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 사용자 ID로 회원 조회
    Optional<Member> findByUsername(String username);
}