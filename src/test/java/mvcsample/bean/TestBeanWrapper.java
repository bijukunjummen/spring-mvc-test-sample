package mvcsample.bean;

import mvcsample.domain.Member;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

public class TestBeanWrapper {

	@Test
	public void testBeanWrapper() {
		BeanWrapper memberWrapped = new BeanWrapperImpl(new Member());
		memberWrapped.setAutoGrowNestedPaths(true);
		PropertyValue pv1 = new PropertyValue("first", "john");
		PropertyValue pv2 = new PropertyValue("last", "doe");
		
		memberWrapped.setPropertyValue(pv1);
		memberWrapped.setPropertyValue(pv2);
		
		PropertyValue pvN1 = new PropertyValue("addresses[2].line1", "Address 2 line 1");
		memberWrapped.setPropertyValue(pvN1);
		PropertyValue pvN2 = new PropertyValue("addresses[0].line1", "Address 0 line 1");
		memberWrapped.setPropertyValue(pvN2);
		Member member = (Member)memberWrapped.getWrappedInstance();
		System.out.println(member.getAddresses());
	}

}
