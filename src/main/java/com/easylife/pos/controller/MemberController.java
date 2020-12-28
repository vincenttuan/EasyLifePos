package com.easylife.pos.controller;

import com.easylife.pos.entity.Member;
import com.easylife.pos.repository.MemberRepository;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
    
    @Autowired
    private MemberRepository repository;
    
    @GetMapping("/")
    //@ResponseBody
    public String findAll(Model model) {
        List<Member> members = repository.queryAll();
        Map<String, Long> mapSex = members
                .stream()
                .map(m -> m.getMsex())
                .collect(Collectors.groupingBy( 
                                Function.identity(), 
                                Collectors.counting()));
        model.addAttribute("members", members); // 將資料放入 Model 容器，如此 jsp 便可接收
        model.addAttribute("mapSex", mapSex);
        return "member"; // 轉跳到 /WEB-INF/view/member.jsp
    }
    
}
