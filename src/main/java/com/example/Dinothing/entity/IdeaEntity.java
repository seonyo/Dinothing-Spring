package com.example.Dinothing.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "ideas")
public class IdeaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String q1;

    @Column(columnDefinition = "TEXT")
    private String q2;

    @Column(columnDefinition = "TEXT")
    private String q3;

    @Column(columnDefinition = "TEXT")
    private String q4;

    @Column(columnDefinition = "TEXT")
    private String q5;

    @Column(columnDefinition = "TEXT")
    private String q6;

    @Column(columnDefinition = "TEXT")
    private String q7;

    @Column
    private String color;

    @Column
    private Integer progress;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
