package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_answers")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_answer_id")
    private int id;

    @Column(name = "user_answer")
    private String answer;

    @Column(name = "user_answer_iscorrect")
    private boolean isCorrect;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "question_id")
    private int question_id;

    @Column(name = "question_kc_id")
    private int question_kc_id;
}
