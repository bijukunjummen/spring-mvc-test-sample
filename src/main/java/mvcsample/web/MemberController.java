package mvcsample.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import mvcsample.domain.Member;
import mvcsample.repositories.MemberRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/members")
public class MemberController {

	@Autowired
	MemberRepository memberRepository;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
	public String create(@Valid Member member, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, member);
			return "members/create";
		}
		uiModel.asMap().clear();
		this.memberRepository.save(member);
		return "redirect:/members";
	}

	@RequestMapping(params = "form", produces = "text/html")
	public String createForm(Model uiModel) {
		populateEditForm(uiModel, new Member());
		return "members/create";
	}

	@RequestMapping(produces = "text/html")
	public String list(Pageable pageable, Model model) {
		System.out.println(pageable);
		Page<Member> members = this.memberRepository.findMembers(pageable);
		model.addAttribute("members", members);
		return "members/list";
	}

	@RequestMapping(params = { "form", "id" }, produces = "text/html")
	public String updateForm(@RequestParam("id") Long id, Model uiModel) {
		populateEditForm(uiModel, this.memberRepository.findOne(id));
		return "members/update";
	}

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
	public String update(@Valid Member member, BindingResult bindingResult,
			Model uiModel, HttpServletRequest httpServletRequest) {
		if (bindingResult.hasErrors()) {
			populateEditForm(uiModel, member);
			return "members/update";
		}
		uiModel.asMap().clear();
		this.memberRepository.save(member);
		return "redirect:/members";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
	public String delete(@PathVariable("id") Long id,
			@RequestParam(value = "page.page", required = false) Integer page,
			@RequestParam(value = "page.size", required = false) Integer size,
			Model uiModel, HttpServletRequest httpServletRequest) {
		Member member = this.memberRepository.findOne(id);
		System.out.println("page: " + page + ", size:" + size);
		this.memberRepository.delete(member);
		uiModel.asMap().clear();
		uiModel.addAttribute("page.page",
				(page == null) ? "1" : page.toString());
		uiModel.addAttribute("page.size",
				(size == null) ? "10" : size.toString());
		return "redirect:/members";
	}

	private void populateEditForm(Model uiModel, Member member) {
		uiModel.addAttribute("member", member);
	}
}