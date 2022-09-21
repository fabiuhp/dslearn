package com.devsuperior.dslearnbds.modules.topic;

import com.devsuperior.dslearnbds.modules.offer.Offer;
import com.devsuperior.dslearnbds.modules.reply.Reply;
import com.devsuperior.dslearnbds.modules.lesson.Lesson;
import com.devsuperior.dslearnbds.modules.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToMany
    @JoinTable(name = "topic_likes",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> likes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Reply answer;

    @OneToMany(mappedBy = "topic")
    private List<Reply> replies = new ArrayList<>();
}
