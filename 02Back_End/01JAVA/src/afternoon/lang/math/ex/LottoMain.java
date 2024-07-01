package afternoon.lang.math.ex;

public class LottoMain {
    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator();

        lottoGenerator.generate();
        lottoGenerator.printLottoNumbers();
    }
}
