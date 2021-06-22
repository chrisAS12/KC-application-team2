package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="answers")
public class TestAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private int id;
    @Column(name = "answer_text")
    private String answers; // "A B C D" ANSWERS.SPLIT(STRING)
    @Column(name = "answer_correct")
    private String correctAnswer;
}
