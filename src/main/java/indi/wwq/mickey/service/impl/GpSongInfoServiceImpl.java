package indi.wwq.mickey.service.impl;

import indi.wwq.mickey.mapper.GpSongInfoMapper;
import indi.wwq.mickey.pojo.GpSongInfo;
import indi.wwq.mickey.service.GpSongInfoService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.provider.base.BaseDeleteProvider;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;
import tk.mybatis.mapper.provider.base.BaseUpdateProvider;

import java.util.List;

/**
 * <p>GpSongInfoService的实现类,
 * 实现了{@link GpSongInfoServiceImpl#insert(GpSongInfo)},
 * {@link GpSongInfoServiceImpl#selectByPrimaryKey(Object)}
 *{@link GpSongInfoServiceImpl#select(GpSongInfo)}
 * {@link GpSongInfoServiceImpl#updateByPrimaryKeySelective(GpSongInfo)}
 * {@link GpSongInfoServiceImpl#deleteByPrimaryKey(Object)}
 * @author wg
 */
@Service
public class GpSongInfoServiceImpl implements GpSongInfoService {
    private final GpSongInfoMapper songInfoMapper;

    public GpSongInfoServiceImpl(GpSongInfoMapper songInfoMapper) {
        this.songInfoMapper = songInfoMapper;
    }

    @Override
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    public int insertSelective(GpSongInfo gpSongInfo) {
        return songInfoMapper.insertSelective(gpSongInfo);
    }

    @Override
    @Options(useCache = false, useGeneratedKeys = false)
    @UpdateProvider(type = BaseUpdateProvider.class, method = "dynamicSQL")
    public int updateByPrimaryKeySelective(GpSongInfo gpSongInfo) {
        return songInfoMapper.updateByPrimaryKeySelective(gpSongInfo);
    }

    @Override
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    public List<GpSongInfo> select(GpSongInfo gpSongInfo) {
        return songInfoMapper.select(gpSongInfo);
    }

    @Override
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    public GpSongInfo selectByPrimaryKey(Object id) {
        return songInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    @DeleteProvider(type = BaseDeleteProvider.class, method = "dynamicSQL")
    public int deleteByPrimaryKey(Object id) {
        return songInfoMapper.deleteByPrimaryKey(id);
    }
}
