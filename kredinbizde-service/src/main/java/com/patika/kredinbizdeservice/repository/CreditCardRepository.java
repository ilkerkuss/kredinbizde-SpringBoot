package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.CreditCard;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
    List<CreditCard> findByBankName(String bankName);

}
