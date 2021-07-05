package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer id;

    @NotEmpty
    @Column(name = "question_type", nullable = false)
    private String type; // Boolean, Radio, Multiple choice

    @NotEmpty
    @Column(name = "question_title", nullable = false)
    private String title;

    @NotEmpty
    @Column(name= "question_answer", nullable = false)
    private String answer;

    @Column(name= "opt1" , nullable = true)
    private String opt1;

    @Column(name= "opt2" , nullable = true)
    private String opt2;

    @Column(name= "opt3" , nullable = true)
    private String opt3;

    @Column(name= "opt4" , nullable = true)
    private String opt4;

    @NotEmpty
    @Column(name= "marks" , nullable = true)
    private int question_marks;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER) // TODO: 7/1/2021 need to check this join
    @JoinColumn(name="question_kc_id", referencedColumnName = "kc_id", nullable = false)
    private KnowledgeCheck knowledgeCheck;

    @Override
    public String toString(){
        return this.getTitle();
    }
}
