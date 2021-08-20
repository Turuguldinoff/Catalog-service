package com.githab.cs.model.searchParams;

import java.util.List;
import java.util.Map;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchParams {
    Map <String, List<String>> filters;
    int offset;
    int limit;

}
