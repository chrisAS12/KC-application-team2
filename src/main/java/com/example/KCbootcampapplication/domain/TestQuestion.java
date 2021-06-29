package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="questions")
public class TestQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;

    @Column(name = "question_body")
    private String question;

    @Column(name = "question_variants")
    private String questionAnswerVariants;

    @Column(name = "question_type")
    private String type;

    @Column(name="test_question_id")
    private int test_question_id;



    public int getId() {
        return id;
    }
}
