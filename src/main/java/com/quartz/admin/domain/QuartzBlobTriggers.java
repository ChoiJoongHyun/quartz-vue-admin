/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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
}
