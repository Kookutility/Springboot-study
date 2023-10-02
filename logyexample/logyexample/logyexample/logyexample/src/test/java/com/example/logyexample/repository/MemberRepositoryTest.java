package com.example.logyexample.repository;

import com.example.logyexample.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test .autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    public void testConnection() {
        Member member = memberRepository.findById(1L).orElse(null);
        assertNotNull(member);
    }
    @Test
    public void findByUsername() {
        // Given
        String username = "testUsername";
        Member member = new Member();
        member.setUsername(username);
        memberRepository.save(member);

        // When
        Optional<Member> foundMember = memberRepository.findByUsername(username);

        // Then
        assertThat(foundMember).isPresent();
        assertThat(foundMember.get().getUsername()).isEqualTo(username);
    }

}