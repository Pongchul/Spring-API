package Hello.HelloSpring.controller;

import Hello.HelloSpring.domain.Member;
import Hello.HelloSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class MemberController {

    private final MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "/members/new")     // 기본적으로 URL창에 치는건 GETMAPPING 주로 조회할 때 씀
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")     //
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());


        memberService.join(member);

        return "redirect:/";

    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers(); // findMember를 쓰면 모든 멤버를 가져올 수 있다.
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
