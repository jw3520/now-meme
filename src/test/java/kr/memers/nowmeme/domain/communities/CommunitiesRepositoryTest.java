package kr.memers.nowmeme.domain.communities;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Column;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunitiesRepositoryTest {

    @Autowired
    CommunitiesRepository communitiesRepository;

    @After
    public void cleanup() {
        communitiesRepository.deleteAll();
    }

    @Test
    public void saveCommunity() {
        String name = "daumCafe";
        String homeUrl = "https://top.cafe.daum.net";
        String articlesUrl = "https://m.cafe.daum.net";
        String logo = "css/logo/daumCafe.png";
        String tag = "";

        communitiesRepository.save(Communities.builder().name(name)
                                                        .homeUrl(homeUrl)
                                                        .articlesUrl(articlesUrl)
                                                        .logo(logo)
                                                        .tag(tag)
                                                        .build());

        List<Communities> communitiesList = communitiesRepository.findAll();
        Communities communities = communitiesList.get(0);
        System.out.println(communities);
    }
}
