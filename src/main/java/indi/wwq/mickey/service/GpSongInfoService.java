package indi.wwq.mickey.service;

import indi.wwq.mickey.pojo.GpSongInfo;

import java.util.List;

public interface GpSongInfoService {
    /**
     * <p>实现对gp_song_info表的插入操作.
     *
     * @param gpSongInfo: 传入gpSongInfo用户数据的插入.
     * @return 返回影响的行数.
     * @see GpSongInfoService#insertSelective(GpSongInfo)
     * @see GpSongInfoService#insertSelective(GpSongInfo) .
     */
    int insertSelective(GpSongInfo gpSongInfo);

    /**
     * <p>根据<code>gpSongInfo</code>中封装的条件在gp_song_info表查询并且返回结果.
     *
     * @param gpSongInfo: 以实体类对象的形式传入要查询的条件.
     * @return 将查找到的数据包装成 {@link List <GpSongInfo>}类型返回.
     * @see GpSongInfoService#select(GpSongInfo).
     */
    List<GpSongInfo> select(GpSongInfo gpSongInfo);

    /**
     * <p>根据主键<code>id</code>在gp_song_info表查询并且返回结果.
     *
     * @param id 要查询的主键值
     * @return 将查找到的数据包装成 {@link GpSongInfo}类型返回.
     * @see GpSongInfoService#selectByPrimaryKey(Object) .
     */
    GpSongInfo selectByPrimaryKey(Object id);

    /**
     * <p>根据<code></code>gpSongInfo </code>中封装的信息在gp_song_info表中更新值.
     * @param gpSongInfo 更新信息的实体类对象
     * @return 返回影响的行数.
     * @see GpSongInfoService#updateByPrimaryKeySelective(GpSongInfo) .
     */
    int updateByPrimaryKeySelective(GpSongInfo gpSongInfo);

    /**
     * <p>根据<code></code>id</code>删除gp_song_info表中的值.
     * @param id 删除信息的id
     * @return 返回影响的行数.
     * @see GpSongInfoService#deleteByPrimaryKey(Object) .
     */
    int deleteByPrimaryKey(Object id);
}
