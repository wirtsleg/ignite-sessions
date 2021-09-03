package com.github.wirtsleg.ignitesessions.repository.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.cache.expiry.ExpiryPolicy;
import java.io.Serializable;
import java.util.Map;

@NoRepositoryBean
public interface IgniteRepository<V, K extends Serializable> extends CrudRepository<V, K> {
    Ignite ignite();

    IgniteCache<K, V> cache();

    <S extends V> S save(K key, S entity);

    <S extends V> Iterable<S> save(Map<K, S> entities);

    <S extends V> S save(K key, S entity, @Nullable ExpiryPolicy expiryPlc);

    <S extends V> Iterable<S> save(Map<K, S> entities, @Nullable ExpiryPolicy expiryPlc);

    V deleteAndGetById(K id);
}
