package mvcsample.bean;

import mvcsample.domain.Member;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

public class TestBeanWrapper {

	@Test
	public void testBeanWrapper() {
		BeanWrapper memberWrapped = new BeanWrapperImpl(new Member());
		ConversionService conversionService = new DefaultFormattingConversionService();
		memberWrapped.setConversionService(conversionService );
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
	
	@Test
	public void testUser() {
		User user = new User();
		user.setUserName("userName");
		BeanWrapper wrapper = new BeanWrapperImpl(user);
		System.out.println(wrapper.getPropertyValue("userName"));
		Errors errors = new BeanPropertyBindingResult(user, "user");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "invalid.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","passwordtxt", "Password should not be empty");
		System.out.println(errors);
	}

	@Test
	public void testModelWithMap() {
		Model model = new Model();
		BeanWrapper wrapper = new BeanWrapperImpl(model);
		System.out.println(wrapper.getPropertyValue("submodel.props[name]"));
	}
}
