package com.bmu.pronostics.repository.search;

import com.bmu.pronostics.domain.Stade;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the User entity.
 */
public interface StadeSearchRepository extends ElasticsearchRepository<Stade, Long> {
}