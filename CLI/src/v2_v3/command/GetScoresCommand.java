package v2_v3.command;

import v2_v3.Input;
import v2_v3.domain.StudentScores;

public class GetScoresCommand implements Command{
    StudentScores studentScores = StudentScores.getInstance();

    // 2) getScores
    @Override
    public void execute() {
        int[] scores = studentScores.getScores();

        for (int i = 0; i < scores.length; i++) {
            scores[i] = Input.getInt("scores[" + i + "]> ");
        }
    }
}
