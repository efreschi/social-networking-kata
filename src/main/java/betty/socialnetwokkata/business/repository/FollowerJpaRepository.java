package betty.socialnetwokkata.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import betty.socialnetwokkata.business.entity.Follower;

@Repository
public interface FollowerJpaRepository extends JpaRepository<Follower, Long> {
}
