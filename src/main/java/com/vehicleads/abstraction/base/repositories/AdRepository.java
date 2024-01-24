package com.vehicleads.abstraction.base.repositories;

import com.vehicleads.abstraction.ads.ad.Ad;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@NoRepositoryBean
public interface AdRepository<T extends Ad> extends BaseRepository<T, Integer> {
    @Transactional(readOnly = true)
    int findUserId(@Param("ad_id") int adId);

    @Transactional(readOnly = true)
    List<T> findAllByUserId(@Param("user_id") int userId);
}
