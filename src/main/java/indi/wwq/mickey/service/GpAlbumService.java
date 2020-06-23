package indi.wwq.mickey.service;

import indi.wwq.mickey.pojo.GpAlbum;

import java.util.List;

/**
 * @author wg
 */
public interface GpAlbumService {
    /**
     * <p>实现对gp_album表的插入操作.
     *
     * @param gpAlbum: 传入gpAlbum用户数据的插入.
     * @return 返回影响的行数.
     * @see GpAlbumService#insertSelective(GpAlbum)
     * @see GpAlbumService#insertSelective(GpAlbum) .
     */
    int insertSelective(GpAlbum gpAlbum);

    /**
     * <p>根据<code>gpAlbum</code>中封装的条件在gp_album表查询并且返回结果.
     *
     * @param gpAlbum: 以实体类对象的形式传入要查询的条件.
     * @return 将查找到的数据包装成 {@link List <GpAlbum>}类型返回.
     * @see GpAlbumService#select(GpAlbum).
     */
    List<GpAlbum> select(GpAlbum gpAlbum);

    /**
     * <p>根据主键<code>id</code>在gp_album表查询并且返回结果.
     *
     * @param id 要查询的主键值
     * @return 将查找到的数据包装成 {@link GpAlbum}类型返回.
     * @see GpAlbumService#selectByPrimaryKey(Object) .
     */
    GpAlbum selectByPrimaryKey(Object id);

    /**
     * <p>根据<code></code>gpAlbum </code>中封装的信息在gp_album表中更新值.
     * @param gpAlbum 更新信息的实体类对象
     * @return 返回影响的行数.
     * @see GpAlbumService#updateByPrimaryKeySelective(GpAlbum) .
     */
    int updateByPrimaryKeySelective(GpAlbum gpAlbum);

    /**
     * <p>根据<code></code>id</code>删除gp_album表中的值.
     * @param id 删除信息的id
     * @return 返回影响的行数.
     * @see GpAlbumService#deleteByPrimaryKey(Object) .
     */
    int deleteByPrimaryKey(Object id);
}
