package cotato.cokathon.repository;

import cotato.cokathon.entity.bucketList.BucketList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketListRepository extends JpaRepository<BucketList, Long> {
}
