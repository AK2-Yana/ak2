package ak2.services.ak2.domain.repos;

import ak2.services.ak2.domain.entities.Ak2User;
import io.lettuce.core.dynamic.annotation.Param;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Ak2UserRepository extends JpaRepository<Ak2User, String> {

    @Override
    @EntityGraph(attributePaths = "roles")
    Optional<Ak2User> findById(@NotNull String id);

    @Query(value = """
              select * 
              from users
              where user_id = :id
           """, nativeQuery = true)
    Optional<Ak2User> selectUserInfoById(@Param("id") String id);
}
