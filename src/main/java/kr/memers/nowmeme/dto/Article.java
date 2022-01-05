package kr.memers.nowmeme.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Article {
    private final String url;
    private final String title;
    private final String commentCount;
    private final String date;
}
