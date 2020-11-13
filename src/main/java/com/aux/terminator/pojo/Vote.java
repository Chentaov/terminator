package com.aux.terminator.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Vote {
    int vote_id;
    String vote_name;
    String vote_des;
    String end_date;
    String sponsor_id;

    int item_id;
    String item_name;
    String voter_id;
    int voted;
}
