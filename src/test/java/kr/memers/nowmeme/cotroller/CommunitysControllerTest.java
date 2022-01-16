package kr.memers.nowmeme.cotroller;

import kr.memers.nowmeme.controller.CommunityController;
import kr.memers.nowmeme.crawler.DaumCafeCrawler;
import kr.memers.nowmeme.crawler.DcInsideCrawler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CommunityController.class)
@Import({DaumCafeCrawler.class, DcInsideCrawler.class})
public class CommunitysControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void returnDaumCafe() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/community/daumCafe"))
               .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void returnDcInside() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/community/dcInside"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
