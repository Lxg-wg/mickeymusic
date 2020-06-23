package indi.wwq.mickey.service;

import indi.wwq.mickey.pojo.GpUser;
import indi.wwq.mickey.pojo.GpUser;

import java.util.List;

/**
 * @author wg
 */
public interface GpUserService {
    /**
     * <p>实现对gp_user表的插入操作.
     *
     * @param gpUser: 传入gpUser用户数据的插入.
     * @return 返回影响的行数.
     * @see GpUserService#insertSelective(GpUser)
     * @see GpUserService#insertSelective(GpUser) .
     */
    int insertSelective(GpUser gpUser);

    /**
     * <p>根据<code>gpUser</code>中封装的条件在gp_user表查询并且返回结果.
     *
     * @param gpUser: 以实体类对象的形式传入要查询的条件.
     * @return 将查找到的数据包装成 {@link List<GpUser>}类型返回.
     * @see GpUserService#select(GpUser).
     */
    List<GpUser> select(GpUser gpUser);

    /**
     * <p>根据主键<code>id</code>在gp_user表查询并且返回结果.
     *
     * @param id 要查询的主键值
     * @return 将查找到的数据包装成 {@link GpUser}类型返回.
     * @see GpUserService#selectByPrimaryKey(Object) .
     */
    GpUser selectByPrimaryKey(Object id);

    /**
     * <p>根据<code></code>gpUser </code>中封装的信息在gp_user表中更新值.
     * @param gpUser 更新信息的实体类对象
     * @return 返回影响的行数.
     * @see GpUserService#updateByPrimaryKeySelective(GpUser) .
     */
    int updateByPrimaryKeySelective(GpUser gpUser);

    /**
     * <p>根据<code></code>id</code>删除gp_user表中的值.
     * @param id 删除信息的id
     * @return 返回影响的行数.
     * @see GpUserService#deleteByPrimaryKey(Object) .
     */
    int deleteByPrimaryKey(Object id);
}
