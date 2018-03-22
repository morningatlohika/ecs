package com.lohika.morning.ecs.domain.campaign;

import lombok.RequiredArgsConstructor;

import com.lohika.morning.ecs.domain.event.MorningEvent;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CampaignService {
  private final CampaignRepository campaignRepository;

  public Campaign findOne(Long id) {
    return campaignRepository.findOne(id);
  }

  public List<Campaign> findAll() {
    return campaignRepository.findAll(new Sort(
        new Sort.Order(Sort.Direction.ASC, "event.eventNumber"),
        new Sort.Order(Sort.Direction.ASC, "priority")));
  }

  public List<Campaign> filterBy(String value) {
    return campaignRepository.findByNameContainingIgnoringCaseOrSubjectContainingIgnoringCase(value, value);
  }
  public List<Campaign> findByEventId(MorningEvent event) {
    return campaignRepository.findByEvent(event);
  }

  public void save(Campaign campaign) {
    campaignRepository.save(campaign);
  }

  public void save(Iterable<Campaign> campaigns) {
    campaignRepository.save(campaigns);
  }

  public void delete(Campaign unsubscribe) {
    campaignRepository.delete(unsubscribe);
  }

  public Campaign newCampaign() {
    return Campaign.builder()
        .build();
  }
}
