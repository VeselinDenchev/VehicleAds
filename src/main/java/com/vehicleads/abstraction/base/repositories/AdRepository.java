package com.vehicleads.abstraction.base.repositories;

import com.vehicleads.abstraction.ads.ad.Ad;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
public interface AdRepository<T extends Ad> extends BaseRepository<T, Integer> {
    @Transactional(readOnly = true)
    int findUserId(@Param("ad_id") int adId);
}
