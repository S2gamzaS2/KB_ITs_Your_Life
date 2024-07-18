package v4.command;

public class ExitCommand implements Command {
    // 5) exit()
    @Override
    public void execute() {
        System.out.println("프로그램 종료");
        System.exit(0);
    }
}
