package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class testAnswer {
    private String id;
    private List<String> answers;
    private String correctAnswer;
}
