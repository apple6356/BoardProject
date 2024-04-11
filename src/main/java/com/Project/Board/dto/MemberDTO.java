package com.Project.Board.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor  // 기본 생성자 자동 생성
@AllArgsConstructor // 필드를 매개변수로 하는 생성자 생성
@ToString
public class MemberDTO {
    private long id;
    private String userId;
    private String userPassword;
    private String userEmail;
}
