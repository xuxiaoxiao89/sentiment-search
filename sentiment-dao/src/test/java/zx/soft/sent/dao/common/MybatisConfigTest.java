package zx.soft.sent.dao.common;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;

public class MybatisConfigTest {

	@Ignore
	public void testGetConfig() {
		SqlSessionFactory sqlSessionFactory = MybatisConfig.getSqlSessionFactory(MybatisConfig.ServerEnum.sentiment);
		assertNotNull(sqlSessionFactory);
		assertTrue(sqlSessionFactory.getConfiguration().getEnvironment().getId().length() > 0);
	}

}
