package com.example.KCbootcampapplication.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
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
    @Column(name = "kc_id")
    private int id;

    @NotEmpty
    @Column(name = "kc_name")
    private String kcName;

    @Column(name = "kc_show")
    private Boolean isShow;

    @Column(name = "kc_start_time")
    private LocalDateTime startTime;

    @Column(name = "kc_finish_time")
    private LocalDateTime finishTime;

    //Knowledge Check Teacher relationship
    @ManyToOne(fetch=FetchType.LAZY) // TODO: 7/1/2021 need to check join 
    @JoinColumn(name="user_id")
    private User user;

    // Quiz Question RelationShip
    @OneToMany(mappedBy = "knowledgeCheck") // TODO: 7/1/2021 need to check this line of code (mapped by) 
    private List<Question> question;
}
