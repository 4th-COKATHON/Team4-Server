package cotato.cokathon.repository;

import cotato.cokathon.entity.bucketList.BucketList;
import cotato.cokathon.entity.bucketList.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketListRepository extends JpaRepository<BucketList, Long> {

    List<BucketList> findAllByOrderByCategoryAsc();
    List<BucketList> findAllByCategory(Category category);
}
