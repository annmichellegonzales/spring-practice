package com.ann.springpractice.models;

import jdk.jfr.Category;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "ads")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @OneToOne
    private User owner;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "ad")
    private List<Image> images;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ads_categories",
            joinColumns = {@JoinColumn(name = "ad_id")},
            inverseJoinColumns={@JoinColumn(name="category_id")}
    )
    private List<Category> categories;



    public Ad() {
    }

}
