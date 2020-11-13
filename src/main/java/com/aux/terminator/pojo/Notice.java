package com.aux.terminator.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Notice {
    int notice_id;
    String notice_title;
    String notice_content;
    String release_time;
    String releaser_id;
}
