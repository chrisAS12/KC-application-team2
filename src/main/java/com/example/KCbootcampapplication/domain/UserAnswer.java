package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_answers")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_answer_id")
    private int id;

    @Column(name = "user_answer")
    private String answer; // "A B C D" ANSWERS.SPLIT(STRING)

    @Column(name = "user_answer_iscorrect")
    private boolean isCorrect;

}
