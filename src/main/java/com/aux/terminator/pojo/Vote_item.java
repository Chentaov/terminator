package com.aux.terminator.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Vote_item {
    int item_id;
    String item_name;
    int vote_id;
    String voter_id;
    int item_num;
}
