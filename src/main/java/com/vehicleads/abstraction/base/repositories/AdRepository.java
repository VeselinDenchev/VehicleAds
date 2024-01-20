package com.vehicleads.abstraction.base.repositories;

import com.vehicleads.abstraction.ads.ad.Ad;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AdRepository<T extends Ad> extends BaseRepository<T, Integer> {
}
