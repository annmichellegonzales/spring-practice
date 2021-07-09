package com.ann.springpractice.models;

import javax.persistence.*;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String path;

    @ManyToOne
    @JoinColumn(name = "ad_id")
    private Ad ad;

    public Image() {
    }
}
