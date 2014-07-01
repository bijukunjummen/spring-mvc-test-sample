package mvcsample.bean;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

public class TestBeanWrapperInner {

	@Test
	public void testBeanWrapper() {
		BeanWrapper nestedWrapped = new BeanWrapperImpl(new NestedClass());
		nestedWrapped.setAutoGrowNestedPaths(true);
		PropertyValue pv1 = new PropertyValue("inners[0].innerField", "field1");
		PropertyValue pv2 = new PropertyValue("inners[1].innerField", "field2");
		
		nestedWrapped.setPropertyValue(pv1);
		nestedWrapped.setPropertyValue(pv2);
		

		NestedClass nestedClass = (NestedClass)nestedWrapped.getWrappedInstance();
		System.out.println(nestedClass);
	}
}
