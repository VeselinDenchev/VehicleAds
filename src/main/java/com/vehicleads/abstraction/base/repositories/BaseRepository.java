package com.vehicleads.abstraction.base.repositories;

import com.vehicleads.abstraction.base.entity.BaseEntity;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity<U>, U extends Serializable>
        extends Repository<T, U> {
    @Transactional(readOnly = true)
    boolean existsById(U id);

    @Transactional(readOnly = true)
    List<T> findAll() throws DataAccessException;

    @Transactional(readOnly = true)
    Optional<T> findById(U id);

    void save(T entity);

    void deleteById(U id);
}
