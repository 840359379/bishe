/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Administrators;

public interface AdministratorsService {

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    Administrators selectAdministrators(String account, String password);
}
