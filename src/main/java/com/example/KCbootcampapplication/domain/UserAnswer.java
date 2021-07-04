package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data // TODO: 7/1/2021 Do we need this class now? 
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

    @Column(name = "user_score") // TODO: 7/4/2021 need to store user calculated results 
    private Double score;
}
