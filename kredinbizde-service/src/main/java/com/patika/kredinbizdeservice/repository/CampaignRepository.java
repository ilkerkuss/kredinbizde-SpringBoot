package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.model.Campaign;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public interface CampaignRepository  extends JpaRepository<Campaign,Long> {

}
