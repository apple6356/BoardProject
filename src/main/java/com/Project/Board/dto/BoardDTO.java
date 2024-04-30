package com.Project.Board.dto;

import com.Project.Board.entity.BoardEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor  // 기본 생성자 자동 생성
@AllArgsConstructor // 필드를 매개변수로 하는 생성자 생성
public class BoardDTO {

    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private LocalDateTime boardCreateTime;
    private LocalDateTime boardUpdateTime;

    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardEntity.getId());
        boardDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDTO.setBoardPass(boardEntity.getBoardPass());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setBoardCreateTime(boardEntity.getCreatedTime());
        boardDTO.setBoardUpdateTime(boardEntity.getUpdateTime());

        return boardDTO;
    }
}
