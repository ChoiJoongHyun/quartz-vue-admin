/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "QRTZ_CRON_TRIGGERS")
@NamedEntityGraph(
        name = QuartzCronTriggers.NAMED_ENTITY_GRAPH_KEY,
        attributeNodes = @NamedAttributeNode(value = "trigger", subgraph = "trigger.jobDetails"),
        subgraphs = @NamedSubgraph(name = "trigger.jobDetails", attributeNodes = @NamedAttributeNode(value = "jobDetails"))
)
public class QuartzCronTriggers implements Serializable {

    public static final String NAMED_ENTITY_GRAPH_KEY = "QRTZ_CRON_TRIGGERS.FETCH";

    @EmbeddedId
    private TriggerId id;

    @Column(name = "CRON_EXPRESSION", nullable = false, length = 200)
    private String cronExpression;

    @Column(name = "TIME_ZONE_ID", length = 80)
    private String timeZoneId;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @PrimaryKeyJoinColumn
    private QuartzTriggers trigger;
}
