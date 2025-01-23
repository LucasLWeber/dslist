package com.lucasweber.dslist.dto;


import com.lucasweber.dslist.entities.Game;
import com.lucasweber.dslist.projections.GameMinProjection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class GameMinDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO(Game game){
        BeanUtils.copyProperties(game, this);
    }

    public GameMinDTO(GameMinProjection projection){
        this.id = projection.getId();
        this.title = projection.getTitle();
        this.year = projection.getGameYear();
        this.imgUrl = projection.getImgUrl();
        this.shortDescription = projection.getShortDescription();
    }
}
