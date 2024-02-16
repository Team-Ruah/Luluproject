package org.ohgiraffers.luluproject.domain;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long post_id;

    @Column(length = 50, nullable = false)
    private String title;

    @Column(length = 300, nullable = false)
    private String content;

}

