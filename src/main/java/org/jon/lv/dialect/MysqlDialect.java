package org.jon.lv.dialect;


import org.jon.lv.pagination.Page;

/*
 * Copyright (C), 2012-2014
 * Author:   Administrator
 * Date:     14-10-24
 * Description: 模块目的、功能描述      
 * History: 变更记录
 * <author>           <time>             <version>        <desc>
 * Administrator           14-10-24           00000001         创建文件
 *
 */
public class MysqlDialect implements Dialect{

    @Override
    public String pageSql(String sql, Page page) {

        StringBuffer querySql =
                new StringBuffer("SELECT * FROM ( ").append(sql).append(" ) AS COUNT_PAGE")
                        .append(" LIMIT ").append( page.getStart() ).append(" , ").append(page.getPageSize());
        return querySql.toString();
    }
}
