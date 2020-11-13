package com.aux.terminator.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Pages {
    int page_id;
    String page_name;
    String page_link;
    String page_type;
    String page_des;
    String release_time;
}
