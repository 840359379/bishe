/*
 *
 *  * 盛建辉：毕设
 *  *
 *  * 版权归本公司所有，不得私自使用、拷贝、修改、删除，否则视为侵权
 *
 */

package com.chuanmei.bishe.dao;

import com.chuanmei.bishe.model.User;
import com.chuanmei.bishe.model.Whimsy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WhimsyDao {
    /**
     * 添加一个随想
     * @param whimsy
     * @return
     */
    public boolean addWhimsy(Whimsy whimsy);

    /**
     * 删除一个随想
     * @param id
     * @return
     */
    public boolean deleteWhimsy(int id);

    /**
     * 更改一个随想
     * @param whimsy
     * @return
     */
    public boolean updateWhimsy(Whimsy whimsy);

    /**
     * 找到狠多随想
     * @return
     */
    public List<Whimsy> selectList(String account);

    /**
     * 找到一系列贴子
     * @param series
     * @return
     */
    public List<Whimsy> seriesWhimsy(int series);

    public User test(int id);
}
