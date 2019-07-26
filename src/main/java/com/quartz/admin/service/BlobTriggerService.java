/**
 * Created by joonghyun on 2019-07-17
 */
package com.quartz.admin.service;

import com.quartz.admin.domain.QuartzBlobTriggers;
import com.quartz.admin.domain.TriggerId;
import com.quartz.admin.repository.BlobTriggerRepository;
import com.quartz.admin.service.dto.BlobTriggerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class BlobTriggerService {

    private final BlobTriggerRepository blobTriggerRepository;

    public List<BlobTriggerDTO> findAll() {
        List<QuartzBlobTriggers> blobTriggers = blobTriggerRepository.findAll();
        return BlobTriggerDTO.from(blobTriggers);
    }

    public void deleteById(TriggerId triggerId) {
        blobTriggerRepository.deleteById(triggerId);
    }
}
