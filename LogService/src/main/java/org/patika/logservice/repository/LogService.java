package org.patika.logservice.repository;

import lombok.RequiredArgsConstructor;
import org.patika.logservice.entity.Log;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService {

    private final ILogRepository logRepository;

    public Log insertLog(Log log){
        return logRepository.insert(log);
    }

}
