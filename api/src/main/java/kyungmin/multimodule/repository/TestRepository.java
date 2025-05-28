package kyungmin.multimodule.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import kyungmin.multimodule.domain.QTest;
import kyungmin.multimodule.domain.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Transactional
public class TestRepository {
  private final JPAQueryFactory queryFactory;

  public void save(Test test) {
    this.queryFactory.insert(QTest.test)
      .columns(QTest.test.title, QTest.test.content)
      .values(test.getTitle(), test.getContent())
      .execute();
  }

  public Test getById(Long id) {
    return this.queryFactory.select(QTest.test)
      .from(QTest.test)
      .where(QTest.test.id.eq(id))
      .fetchOne();
  }
}
