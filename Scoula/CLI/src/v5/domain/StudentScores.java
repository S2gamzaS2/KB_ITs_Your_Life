package v5.domain;

// 데이터 관리 클래스
public class StudentScores {
    int studentNum = 0;
    int[] scores = null;

    // Singleton 패턴
        // 생성자-private
        // static 멤버로 딱 한 번 초기화 - private (Null 대입 못하게 하려고)
        // getInstance() - public
    private StudentScores() {}
    private static StudentScores instance = new StudentScores();
    public static StudentScores getInstance() {
        return instance;
    }

    // 학생수 리턴
    public int getStudentNum() {
        return studentNum;
    }

    // 학생수 설정
    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
        this.scores = new int[studentNum];
    }

    // 점수 리턴
    public int[] getScores() {
        return scores;
    }
}
