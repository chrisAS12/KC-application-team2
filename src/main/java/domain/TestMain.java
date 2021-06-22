package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestMain {
    private String id;
    private String questionIDs;
    private Date testStartTime;
    private Date testEndTime;
}
