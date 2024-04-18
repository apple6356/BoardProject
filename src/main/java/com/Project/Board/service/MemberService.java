package com.Project.Board.service;

import com.Project.Board.dto.MemberDTO;
import com.Project.Board.entity.MemberEntity;
import com.Project.Board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public MemberDTO login(MemberDTO memberDTO) {

        Optional<MemberEntity> byMemberId = memberRepository.findByMemberId(memberDTO.getMemberId());

        if (byMemberId.isPresent()) {
            // 조회 결과 있음
            MemberEntity memberEntity = byMemberId.get();

            if (memberEntity.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                // 비밀번호 일치
                // entity -> dto 변환 후 리턴
                MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
                return dto;
            } else {
                // 비밀번호 불일치
                return null;
            }

        } else {
            // 조회 결과 없음
            return null;
        }
    }

    public List<MemberDTO> findAll() {
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        List<MemberDTO> memberDTOList = new ArrayList<>();
        for (MemberEntity memberEntity : memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }

        return memberDTOList;
    }

    public MemberDTO findById(Long id) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findById(id);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public MemberDTO updateForm(String myId) {
        Optional<MemberEntity> optionalMemberEntity = memberRepository.findByMemberId(myId);
        if (optionalMemberEntity.isPresent()) {
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        } else {
            return null;
        }
    }

    public void update(MemberDTO memberDTO) {
        memberRepository.save(MemberEntity.toUpdateMemberEntity(memberDTO));
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
