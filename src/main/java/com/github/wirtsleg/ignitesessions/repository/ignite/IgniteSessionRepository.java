package com.github.wirtsleg.ignitesessions.repository.ignite;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.session.MapSession;
import org.springframework.stereotype.Repository;

import java.time.Duration;

@Repository
@RequiredArgsConstructor
public class IgniteSessionRepository implements org.springframework.session.SessionRepository<MapSession> {
    private final SessionRepository sessionRepo;

    @Value("${sessions.maxInactiveInterval:1800}")
    private final long maxInactiveInterval;

    @Override
    public MapSession createSession() {
        MapSession session = new MapSession();

        session.setMaxInactiveInterval(Duration.ofMinutes(maxInactiveInterval));

        return session;
    }

    @Override
    public void save(MapSession session) {
        sessionRepo.save(session.getId(), session);
    }

    @Override
    public MapSession findById(String id) {
        return sessionRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteById(String id) {
        sessionRepo.deleteById(id);
    }
}
