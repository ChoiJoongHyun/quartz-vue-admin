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
@Table(name = "QRTZ_BLOB_TRIGGERS")
public class QuartzBlobTriggers implements Serializable {

    @EmbeddedId
    private TriggerId id;

    @Column(name = "BLOB_DATA")
    private String blobData;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @PrimaryKeyJoinColumn
    private QuartzTriggers trigger;
}
