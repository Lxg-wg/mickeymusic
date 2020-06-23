package indi.wwq.mickey.service.impl;

import indi.wwq.mickey.mapper.GpAlbumMapper;
import indi.wwq.mickey.pojo.GpAlbum;
import indi.wwq.mickey.service.GpAlbumService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.provider.base.BaseDeleteProvider;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;
import tk.mybatis.mapper.provider.base.BaseUpdateProvider;

import java.util.List;

/**
 * <p>GpAlbumService的实现类,
 * 实现了{@link GpAlbumServiceImpl#insert(GpAlbum)},
 * {@link GpAlbumServiceImpl#insert(GpAlbum)}
 *
 * @author wg
 */
@Service
public class GpAlbumServiceImpl implements GpAlbumService {
    private final GpAlbumMapper albumMapper;

    public GpAlbumServiceImpl(GpAlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    @Override
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    public int insertSelective(GpAlbum gpAlbum) {
        return albumMapper.insertSelective(gpAlbum);
    }

    @Override
    @Options(useCache = false, useGeneratedKeys = false)
    @UpdateProvider(type = BaseUpdateProvider.class, method = "dynamicSQL")
    public int updateByPrimaryKeySelective(GpAlbum gpAlbum) {
        return albumMapper.updateByPrimaryKeySelective(gpAlbum);
    }

    @Override
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    public List<GpAlbum> select(GpAlbum gpAlbum) {
        return albumMapper.select(gpAlbum);
    }

    @Override
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    public GpAlbum selectByPrimaryKey(Object id) {
        return albumMapper.selectByPrimaryKey(id);
    }

    @Override
    @DeleteProvider(type = BaseDeleteProvider.class, method = "dynamicSQL")
    public int deleteByPrimaryKey(Object id) {
        return albumMapper.deleteByPrimaryKey(id);
    }
}
