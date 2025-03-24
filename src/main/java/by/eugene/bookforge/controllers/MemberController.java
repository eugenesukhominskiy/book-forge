package by.eugene.bookforge.controllers;

import by.eugene.bookforge.dto.MemberDTO;
import by.eugene.bookforge.models.Member;
import by.eugene.bookforge.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/register")
    private ResponseEntity<Member> registration(@RequestBody MemberDTO member) {
        return ResponseEntity.ok(memberService.create(member));
    }

    @GetMapping("/get/{id}")
    private ResponseEntity<Member> get(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.read(id));
    }

    //TODO: Method "edit" should be editing by id
    @PatchMapping("/edit")
    private ResponseEntity<Member> edit(@RequestBody MemberDTO member) {
        return ResponseEntity.ok(memberService.update(member));
    }

    @DeleteMapping("/delete/{id}")
    private HttpStatus delete(@PathVariable Long id) {
        memberService.delete(id);
        return HttpStatus.OK;
    }
}
