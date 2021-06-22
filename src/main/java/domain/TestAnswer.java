package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestAnswer {
    private int id;
    private String answers; // "A B C D" ANSWERS.SPLIT(STRING)
    private String correctAnswer;
}