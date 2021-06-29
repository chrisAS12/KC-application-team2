package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "question_text")
    private String question;

    @Column(name = "question_type")
    private String type;

    @Column(name = "question_correct_answer")
    private String correctAnswer;

//    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
//    @JoinColumn(name="kc_question_id", referencedColumnName = "test_id", nullable = false)
//    private KnowledgeCheck knowledgeCheck;

    public int getId() {
        return id;
    }
}
