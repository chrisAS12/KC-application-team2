package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
