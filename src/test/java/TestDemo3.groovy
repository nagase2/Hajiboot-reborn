import spock.lang.Specification;

import com.example.domain.Supplier;
import com.example.log.demo.Calc;


class TestDemo3  extends Specification{
	private Calc instance;
	private Supplier supplier;
	
		def setup() {
			instance = new Calc()
			supplier=new Supplier()
			
			
		}
	
		def "２つの値の合計チェック"() {
			
			expect:
			
	
			where:
			a | b | c
			1 | 3 | 4
			7 | 4 | 11
			0 | 0 | 0
			
		}
		
	
}
