package com.chuanmei.bishe.service;

import com.chuanmei.bishe.model.Whimsy;

import java.util.List;

public interface WhimsyService {

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
     * 找到我的随想
     * @return
     */
    public List<Whimsy> selectList(String account);

    /**
     * 找到一系列贴子
     * @param series
     * @return
     */
    public List<Whimsy> seriesWhimsy(int series);


}
