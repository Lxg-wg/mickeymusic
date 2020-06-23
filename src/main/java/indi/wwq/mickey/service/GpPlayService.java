package indi.wwq.mickey.service;

import indi.wwq.mickey.pojo.GpPlay;

import java.util.List;

/**
 * @author wg
 */
public interface GpPlayService {
    /**
     * <p>实现对gp_play表的插入操作.
     *
     * @param gpPlay: 传入gpPlay用户数据的插入.
     * @return 返回影响的行数.
     * @see GpPlayService#insertSelective(GpPlay)
     * @see GpPlayService#insertSelective(GpPlay) .
     */
    int insertSelective(GpPlay gpPlay);

    /**
     * <p>根据<code>gpPlay</code>中封装的条件在gp_play表查询并且返回结果.
     *
     * @param gpPlay: 以实体类对象的形式传入要查询的条件.
     * @return 将查找到的数据包装成 {@link List<GpPlay>}类型返回.
     * @see GpPlayService#select(GpPlay).
     */
    List<GpPlay> select(GpPlay gpPlay);

    /**
     * <p>根据主键<code>id</code>在gp_play表查询并且返回结果.
     *
     * @param id 要查询的主键值
     * @return 将查找到的数据包装成 {@link GpPlay}类型返回.
     * @see GpPlayService#selectByPrimaryKey(Object) .
     */
    GpPlay selectByPrimaryKey(Object id);

    /**
     * <p>根据<code></code>gpPlay </code>中封装的信息在gp_play表中更新值.
     * @param gpPlay 更新信息的实体类对象
     * @return 返回影响的行数.
     * @see GpPlayService#updateByPrimaryKeySelective(GpPlay) .
     */
    int updateByPrimaryKeySelective(GpPlay gpPlay);

    /**
     * <p>根据<code></code>id</code>删除gp_play表中的值.
     * @param id 删除信息的id
     * @return 返回影响的行数.
     * @see GpPlayService#deleteByPrimaryKey(Object) .
     */
    int deleteByPrimaryKey(Object id);

    /**
     * <p>根据<code>gpPlay </code>中封装的信息在gp_play表中进行分页查询.
     * @param gpPlay 封装的信息
     * @param page 请求的页数
     * @param pageSize 页面包含多少条信息
     * @return 以List<GpPlay>形式返回查询的结果
     * @see GpPlay
     */
    List<GpPlay> queryListPaged(GpPlay gpPlay,Integer page,Integer pageSize);
}
