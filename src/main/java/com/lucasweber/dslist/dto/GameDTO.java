package com.lucasweber.dslist.dto;

import com.lucasweber.dslist.entities.Game;
import lombok.*;
import org.springframework.beans.BeanUtils;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GameDTO {
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(Game game) {
        BeanUtils.copyProperties(game, this);
    }
}
