package v6.command;

import v6.Input;
import v6.domain.StudentScores;

public class GetScoresCommand implements Command {
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
