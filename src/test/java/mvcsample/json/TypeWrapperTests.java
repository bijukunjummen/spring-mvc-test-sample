package mvcsample.json;


import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import mvcsample.domain.Member;
import mvcsample.types.ListWrapper;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TypeWrapperTests {

	@Test
	public void testTypeWrapper() throws Exception {
		List<Member> members = new ArrayList<>();
		members.add(new Member("one", "one"));
		members.add(new Member("two", "two"));
		ListWrapper<Member> membersWrapper = new ListWrapper<>();
		membersWrapper.setAaData(members);
		membersWrapper.setiTotalDisplayRecords(10);
		membersWrapper.setiTotalRecords(100);
		ObjectMapper objectMapper = new ObjectMapper();
		
		StringWriter w = new StringWriter();
		objectMapper.writeValue(w, membersWrapper);
		String json = w.toString();
		System.out.println(json);
		
//		ListWrapper<Member> membersUpdated = objectMapper.readValue(json, ListWrapper.class);
		ListWrapper<Member> membersUpdated = objectMapper.readValue(w.toString(), new TypeReference<ListWrapper<Member>>() {});
		System.out.println(membersUpdated);
		
		Member member1 = membersUpdated.getAaData().get(0);
	}

}
