/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
@Entity
@Table(name = "QRTZ_SIMPLE_TRIGGERS")
@NamedEntityGraph(
        name = QuartzSimpleTriggers.NAMED_ENTITY_GRAPH_KEY,
        attributeNodes = @NamedAttributeNode(value = "trigger", subgraph = "trigger.jobDetails"),
        subgraphs = @NamedSubgraph(name = "trigger.jobDetails", attributeNodes = @NamedAttributeNode(value = "jobDetails"))
)
public class QuartzSimpleTriggers implements Serializable {

    public static final String NAMED_ENTITY_GRAPH_KEY = "QRTZ_SIMPLE_TRIGGERS.FETCH";

    @EmbeddedId
    private TriggerId id;

    /**
     * repeatCount = 0 -> one execution
     * repeatCount = 1 -> two execution
     * */
    @Column(name = "REPEAT_COUNT", nullable = false)
    private long repeatCount;

    @Column(name = "REPEAT_INTERVAL", nullable = false)
    private long repeatInterval;

    @Column(name = "TIMES_TRIGGERED", nullable = false)
    private long timesTriggered;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @PrimaryKeyJoinColumn
    private QuartzTriggers trigger;

    public long getHumanReadableRepeatCount() {
        return repeatCount + 1;
    }
}
