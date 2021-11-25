package betty.socialnetwokkata.business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import betty.socialnetwokkata.business.entity.Message;

@Repository
public interface MessageJpaRepository extends JpaRepository<Message, Long> {

	public List<Message> findByUsername(String username);
	
    @Query("select m from Message m left join Follower f on f.username = m.username where (m.username = :username or f.follower = :username)")
	public List<Message> findByUsernameOrFollower(@Param("username") String username);
}
