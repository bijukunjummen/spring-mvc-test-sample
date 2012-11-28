package mvcsample.web;

import java.util.List;

import javax.validation.Valid;

import mvcsample.domain.Member;
import mvcsample.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/membersjson")
public class MemberJsonController {
	
	@Autowired MemberRepository memberRepository;
		
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Member create(@RequestBody @Valid Member member, BindingResult bindingResult) {
        return this.memberRepository.save(member);
    }
    
	@RequestMapping
	public @ResponseBody List<Member> list(){
        return this.memberRepository.findAll();
	}
	
    @RequestMapping(value = "/{id}")
    public @ResponseBody Member show(@PathVariable("id") Long id) {
    	return this.memberRepository.findOne(id);
    }

	
    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Member update(@RequestBody @Valid Member member, BindingResult bindingResult) {
    	System.out.println("In Update: " + member);
        return this.memberRepository.save(member);
    }
	
	
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        Member member = this.memberRepository.findOne(id);
        this.memberRepository.delete(member);
    }

}