

import hello.world.jpa.Calc;
import hello.world.jpa.MySampleLayout;
import spock.lang.*;


class CalcSpec extends Specification{

    private Calc instance;
    private MySampleLayout layout;

    def setup() {
        instance = new Calc()
        layout = new MySampleLayout();
    }

    def "adding two numbers｜２つの値の合計チェック"() {
        expect:
        instance.add(a, b) == c

        where:
        a | b | c
        1 | 3 | 4
        7 | 4 | 11
        0 | 0 | 0
		
    }
    
}