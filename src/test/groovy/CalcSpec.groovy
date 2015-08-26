

import hello.world.jpa.Calc;
import hello.world.jpa.MySampleLayout;
import spock.lang.*;

/**
 * 渡した値を演算するCalcクラスのテストを行う。
 * @author ac12955
 *
 */
class CalcSpec extends Specification{

    private Calc instance;
    private MySampleLayout layout;

    def setup() {
        instance = new Calc()
        layout = new MySampleLayout();
    }
    /**
     * 1...限界値テスト
     * 2...通常値テスト
     * 3...0の場合
     * @return
     */
    def "２つの値の合計チェック"() {
        expect:
        instance.add(a, b) == c

        where:
        a       | b | c
        65535   | 1 | 65536
        7       | 4 | 11
        0       | 0 | 0
    }
}