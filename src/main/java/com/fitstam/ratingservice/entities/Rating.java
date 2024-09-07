package com.fitstam.ratingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ratings")
public class Rating {
    @Id
    @Column(name="ratingid")
    private String ratingId;
    @Column(name="userid")
    private String userId;
    @Column(name="hotelid")
    private String hotelId;
    @Column(name="ratingstar")
    private int ratingStar;
    @Column(name="feedback")
    private String feedback;

    @Transient
    private  Hotel hotel;
}
