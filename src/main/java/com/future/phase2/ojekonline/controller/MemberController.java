package com.future.phase2.ojekonline.controller;

import com.future.phase2.ojekonline.entity.Member;
import com.future.phase2.ojekonline.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Member>> getAllMembers(){
        return new ResponseEntity<>(memberService.getAllMembers(), HttpStatus.OK);
    }

    @GetMapping("/{id}/view")
    @ResponseBody
    public ResponseEntity<Member> getMember(@PathVariable Long id){
        return new ResponseEntity<>(memberService.getMember(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        return new ResponseEntity<>(memberService.createMember(member), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/edit")
    @ResponseBody
    public ResponseEntity<Member> editMember(@PathVariable Long id, @RequestBody Member member){
        return new ResponseEntity<>(memberService.updateMember(id, member), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseBody
    public ResponseEntity<String> deleteMember(@PathVariable Long id){
        memberService.deleteMember(id);
        return new ResponseEntity<>("Member already deleted", HttpStatus.OK);
    }

}
