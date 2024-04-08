package org.patika.garantiservice.repository;



import org.patika.garantiservice.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
//
//    private List<Application> applicationList = new ArrayList<>();
//
//    public Application save(Application application) {
//        applicationList.add(application);
//        return application;
//    }
//
//    public List<Application> getAll() {
//        return applicationList;
//    }
}
