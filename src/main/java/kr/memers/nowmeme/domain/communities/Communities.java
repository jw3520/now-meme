package kr.memers.nowmeme.domain.communities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Communities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String homeUrl;

    @Column
    private String articlesUrl;

    @Column
    private String logo;

    @Column
    private String tag;

    @Builder
    public Communities(String name, String homeUrl, String articlesUrl, String logo, String tag) {
        this.name = name;
        this.homeUrl = homeUrl;
        this.articlesUrl = articlesUrl;
        this.logo = logo;
        this.tag = tag;
    }
}