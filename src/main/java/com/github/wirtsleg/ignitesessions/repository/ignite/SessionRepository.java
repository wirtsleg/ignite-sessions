package com.github.wirtsleg.ignitesessions.repository.ignite;

import org.apache.ignite.springdata22.repository.config.RepositoryConfig;
import org.springframework.session.MapSession;

import static com.github.wirtsleg.ignitesessions.config.ApplicationConfig.IGNITE_NAME;

@RepositoryConfig(cacheName = "SessionCache", igniteInstance = IGNITE_NAME, autoCreateCache = true)
public interface SessionRepository extends IgniteRepository<MapSession, String> {
}
