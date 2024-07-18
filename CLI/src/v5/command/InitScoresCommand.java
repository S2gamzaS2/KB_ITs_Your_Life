package v5.command;

import v5.Input;
import v5.domain.StudentScores;

public class InitScoresCommand implements Command {
    StudentScores studentScores = StudentScores.getInstance();

    // 1) getStudentNum()
    @Override
    public void execute() {
        int studentNum = Input.getInt("학생수> ");
        studentScores.setStudentNum(studentNum);
    }
}
