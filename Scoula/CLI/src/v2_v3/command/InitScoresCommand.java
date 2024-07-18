package v2_v3.command;

import v2_v3.Input;
import v2_v3.domain.StudentScores;

public class InitScoresCommand implements Command{
    StudentScores studentScores = StudentScores.getInstance();

    // 1) getStudentNum()
    @Override
    public void execute() {
        int studentNum = Input.getInt("학생수> ");
        studentScores.setStudentNum(studentNum);
    }
}
