/**
 * Created by joonghyun on 2019-07-30
 */
package com.quartz.admin.domain.converter;

import com.quartz.admin.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.*;

@Slf4j
@Converter
public class JobDataMapDomainConverter implements AttributeConverter<JobDataMap, byte[]> {

    @Override
    public byte[] convertToDatabaseColumn(JobDataMap attribute) {
        try(ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutput out = new ObjectOutputStream(bos)) {
            out.writeObject(attribute);
            return bos.toByteArray();
        } catch (IOException e) {
            log.error("JobDataMapConverter to bytes converter error", e);
            throw new ServiceException("JobDataMapConverter to bytes converter error");
        }
    }

    @Override
    public JobDataMap convertToEntityAttribute(byte[] dbData) {
        if(dbData == null || dbData.length < 1) {
            return null;
        }

        try (ByteArrayInputStream bis = new ByteArrayInputStream(dbData);
             ObjectInput in = new ObjectInputStream(bis)){
            return  (JobDataMap) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            log.error("JobDataMapConverter to jobDataMap converter error", e);
            throw new ServiceException("JobDataMapConverter to jobDataMap converter error");
        }
    }
}
