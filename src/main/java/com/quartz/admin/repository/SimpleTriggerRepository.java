/**
 * Created by joonghyun on 2019-07-16
 */
package com.quartz.admin.repository;

import com.quartz.admin.domain.QuartzSimpleTriggers;
import com.quartz.admin.domain.TriggerId;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimpleTriggerRepository extends JpaRepository<QuartzSimpleTriggers, TriggerId> {

    @EntityGraph(value = QuartzSimpleTriggers.NAMED_ENTITY_GRAPH_KEY , type = EntityGraph.EntityGraphType.FETCH)
    List<QuartzSimpleTriggers> findAll();
}
