package com.example.logyexample.repository;

import com.example.logyexample.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }

    @Test
    public void findByUsername() {
        String username = "testUser";
        Member member = new Member();
        member.setUsername(username);
        memberRepository.save(member);

        Optional<Member> foundMember = memberRepository.findByUsername(username);

        assertThat(foundMember).isPresent();
        assertThat(foundMember.get().getUsername()).isEqualTo(username);
    }

    @Test
    public void findByUserId() {
        String userId = "testUserId";
        Member member = new Member();
        member.setUserId(userId);
        memberRepository.save(member);

        Optional<Member> foundMember = memberRepository.findByUserId(userId);

        assertThat(foundMember).isPresent();
        assertThat(foundMember.get().getUserId()).isEqualTo(userId);
    }

    @Test
    public void findByEmail() {
        String email = "test@example.com";
        Member member = new Member();
        member.setEmail(email);
        memberRepository.save(member);

        Optional<Member> foundMember = memberRepository.findByEmail(email);

        assertThat(foundMember).isPresent();
        assertThat(foundMember.get().getEmail()).isEqualTo(email);
    }
}