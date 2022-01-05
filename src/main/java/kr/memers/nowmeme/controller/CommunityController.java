package kr.memers.nowmeme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommunityController {

    @GetMapping("/community")
    public String getCommunity() {
        return "Community";
    }
}
