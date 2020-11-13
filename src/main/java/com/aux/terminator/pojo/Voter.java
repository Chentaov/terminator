package com.aux.terminator.pojo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Voter {
    int item_id;
    String item_name;
    int vote_id;
    int item_num;
    String voter_id;
}
