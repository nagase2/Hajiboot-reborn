import spock.lang.Specification;

import com.example.domain.Supplier;
import com.example.log.demo.Calc;
import com.example.log.demo.Demo3;


class TestDemo3  extends Specification{
	private Demo3 demo3
	
	
		def setup() {
			demo3 = new Demo3()
			
		}
	
		def "Demo3の確認"() {
			given:
				def str = "result"
				
			when:
				def result = demo3.startProcess();
			
			then:
				result == "result"
			
		}
		
	
}
