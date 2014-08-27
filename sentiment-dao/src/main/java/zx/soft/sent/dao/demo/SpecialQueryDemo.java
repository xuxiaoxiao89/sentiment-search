package zx.soft.sent.dao.demo;

import zx.soft.sent.dao.common.MybatisConfig;
import zx.soft.sent.dao.special.SpecialQuery;
import zx.soft.sent.utils.checksum.CheckSumUtils;

/**
 * 专题信息CURD
 * 
 * @author wanggang
 *
 */
public class SpecialQueryDemo {

	public static void main(String[] args) {

		SpecialQuery specialQuery = new SpecialQuery(MybatisConfig.ServerEnum.sentiment);
		String keywords = "(合肥 OR 学校) AND 开学";
		String start = "2014-08-27 00:00:00";
		String end = "2014-08-27 23:59:59";
		int hometype = 1;
		String identify = CheckSumUtils.getMD5(keywords + start + end + hometype);
		/**
		 * 插入专题信息
		 */
		specialQuery.insertSpecialInfo(identify, keywords, start, end, hometype);
		/**
		 * 删除专题信息
		 */
		specialQuery.deleteSpecialInfo(identify);
		/**
		 * 插入专题查询结果
		 */
		specialQuery.insertSpecialResult(identify, "solr-query-result-insert");
		/**
		 * 查询专题查询结果
		 */
		System.out.println(specialQuery.selectSpecialResult(identify));
		/**
		 * 更新专题查询结果
		 */
		specialQuery.updateSpecialResult(identify, "solr-query-result-update");
		System.out.println(specialQuery.selectSpecialResult(identify));
		/**
		 * 删除专题查询结果
		 */
		specialQuery.deleteSpecialResult(identify);
	}

}