package com.group.libraryapp.domain.team;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    boolean existsByTeamName(String name);

    Optional<Team> findByTeamName(String name);


}
