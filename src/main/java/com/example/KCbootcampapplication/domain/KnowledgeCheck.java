package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="knowledge_check")
public class KnowledgeCheck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Integer id;

    @Column(name = "kc_name")
    private String kcName;

    @Column(name = "kc_show")
    private Boolean isShow;

    @Column(name = "kc_start_time")
    private LocalDateTime startTime;

    @Column(name = "kc_finish_time")
    private LocalDateTime finishTime;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name="kc_question_id", referencedColumnName = "test_id", nullable = false)
    private List <TestQuestion> questions;

}
