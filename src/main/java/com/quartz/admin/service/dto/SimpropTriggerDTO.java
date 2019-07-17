/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service.dto;

import com.quartz.admin.domain.QuartzSimpropTriggers;
import com.quartz.admin.domain.TriggerId;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PRIVATE)
@Getter
public class SimpropTriggerDTO {

    private TriggerId id;
    private String strProp1;
    private String strProp2;
    private String strProp3;
    private Long intProp1;
    private Long intProp2;
    private Long longProp1;
    private Long longProp2;
    private Double decProp1;
    private Double decProp2;
    private String boolProp1;
    private String boolProp2;

    private TriggerDTO trigger;

    public static SimpropTriggerDTO from(QuartzSimpropTriggers simpropTriggers) {
        return SimpropTriggerDTO.builder()
                .id(simpropTriggers.getId())
                .strProp1(simpropTriggers.getStrProp1())
                .strProp2(simpropTriggers.getStrProp2())
                .strProp3(simpropTriggers.getStrProp3())
                .intProp1(simpropTriggers.getIntProp1())
                .intProp2(simpropTriggers.getIntProp2())
                .longProp1(simpropTriggers.getLongProp1())
                .longProp2(simpropTriggers.getLongProp2())
                .decProp1(simpropTriggers.getDecProp1())
                .decProp2(simpropTriggers.getDecProp2())
                .boolProp1(simpropTriggers.getBoolProp1())
                .boolProp2(simpropTriggers.getBoolProp2())
                .trigger(TriggerDTO.from(simpropTriggers.getTrigger()))
                .build();
    }

    public static List<SimpropTriggerDTO> from(List<QuartzSimpropTriggers> simpropTriggersList) {
        return simpropTriggersList.stream()
                .map(SimpropTriggerDTO::from)
                .collect(Collectors.toList());
    }
}
