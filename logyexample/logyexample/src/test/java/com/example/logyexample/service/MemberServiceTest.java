package com.example.logyexample.service;

import com.example.logyexample.domain.Member;
import com.example.logyexample.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

@SpringBootTest
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @MockBean
    private MemberRepository memberRepository;

    @BeforeEach
    public void setUp() {
        // 테스트 전에 Mock 객체 초기화
        reset(memberRepository);
    }

    @Test
    public void 회원가입() {
        // given
        Member member = new Member();
        member.setUsername("testUser");
        member.setId(1L);  // 임의의 ID 값 설정
        when(memberRepository.findByUsername(any())).thenReturn(Optional.empty());
        when(memberRepository.save(any())).thenReturn(member);

        // when
        Long savedId = memberService.join(member);

        // then
        assertThat(savedId).isNotNull();
        verify(memberRepository, times(1)).save(member);
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setUsername("testUser");

        Member member2 = new Member();
        member2.setUsername("testUser");

        when(memberRepository.findByUsername("testUser")).thenReturn(Optional.of(member1));

        // when & then
        assertThatThrownBy(() -> memberService.join(member2))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("이미 존재하는 회원입니다.");

        verify(memberRepository, never()).save(member2);
    }
}
