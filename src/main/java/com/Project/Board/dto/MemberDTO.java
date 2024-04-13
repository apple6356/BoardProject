package com.Project.Board.dto;

import com.Project.Board.entity.MemberEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 자동 생성
@AllArgsConstructor // 필드를 매개변수로 하는 생성자 생성
@ToString
public class MemberDTO {
    private long id;
    private String memberId;
    private String memberPassword;
    private String memberEmail;

    public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setId(memberEntity.getId());
        memberDTO.setMemberId(memberEntity.getMemberId());
        memberDTO.setMemberPassword(memberEntity.getMemberPassword());
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());

        return memberDTO;
    }
}
