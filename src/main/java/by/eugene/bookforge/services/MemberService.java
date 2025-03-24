package by.eugene.bookforge.services;

import by.eugene.bookforge.dto.MemberDTO;
import by.eugene.bookforge.models.Member;
import by.eugene.bookforge.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member create(MemberDTO memberDTO) {
        Member member = Member.builder()
                .role(memberDTO.getRole())
                .email(memberDTO.getEmail())
                .username(memberDTO.getUsername())
                .password(memberDTO.getPassword())
                .build();
        return memberRepository.save(member);
    }

    public Member read(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    public Member update(MemberDTO memberDTO) {
        Member member = Member.builder()
                .role(memberDTO.getRole())
                .email(memberDTO.getEmail())
                .username(memberDTO.getUsername())
                .password(memberDTO.getPassword())
                .build();
        return memberRepository.save(member);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
