package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestQuestion {
    private int id;
    private String question;
    private String questionAnswerVariants;
    private String type;
}
