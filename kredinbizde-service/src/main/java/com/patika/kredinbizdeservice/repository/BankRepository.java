package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Bank;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface BankRepository extends JpaRepository<Bank,Long> {
    List<Bank> findByName(String name);

}
