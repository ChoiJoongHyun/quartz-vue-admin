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
@Table(name = "QRTZ_SIMPROP_TRIGGERS")
public class QuartzSimpropTriggers implements Serializable {

    @EmbeddedId
    private TriggerId id;

    @Column(name = "STR_PROP_1")
    private String strProp1;

    @Column(name = "STR_PROP_2")
    private String strProp2;

    @Column(name = "STR_PROP_3")
    private String strProp3;

    @Column(name = "INT_PROP_1")
    private Long intProp1;

    @Column(name = "INT_PROP_2")
    private Long intProp2;

    @Column(name = "LONG_PROP_1")
    private Long longProp1;

    @Column(name = "LONG_PROP_2")
    private Long longProp2;

    @Column(name = "DEC_PROP_1")
    private Double decProp1;

    @Column(name = "DEC_PROP_2")
    private Double decProp2;

    @Column(name = "BOOL_PROP_1")
    private String boolProp1;

    @Column(name = "BOOL_PROP_2")
    private String boolProp2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "SCHED_NAME", referencedColumnName = "SCHED_NAME", insertable = false, updatable = false),
            @JoinColumn(name = "TRIGGER_NAME", referencedColumnName = "TRIGGER_NAME", insertable = false, updatable = false),
            @JoinColumn(name = "TRIGGER_GROUP", referencedColumnName = "TRIGGER_GROUP", insertable = false, updatable = false),
    })
    private QuartzTriggers trigger;
}
