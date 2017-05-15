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
public interface Dialect {

    String pageSql(String sql, Page page);
}
