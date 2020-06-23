package indi.wwq.mickey.service.impl;

import com.github.pagehelper.PageHelper;
import indi.wwq.mickey.mapper.GpPlayMapper;
import indi.wwq.mickey.pojo.GpPlay;
import indi.wwq.mickey.service.GpPlayService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.provider.base.BaseDeleteProvider;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;
import tk.mybatis.mapper.provider.base.BaseUpdateProvider;

import java.util.List;

/**
 * <p>GpPlayService的实现类,
 * 实现了{@link GpPlayServiceImpl#insertSelective(GpPlay)},
 * {@link GpPlayServiceImpl#selectByPrimaryKey(Object)}
 *{@link GpPlayServiceImpl#select(GpPlay)}
 * {@link GpPlayServiceImpl#updateByPrimaryKeySelective(GpPlay)}
 * {@link GpPlayServiceImpl#deleteByPrimaryKey(Object)}
 * @author wg
 */
@Service
public class GpPlayServiceImpl implements GpPlayService {
    private final GpPlayMapper playMapper;

    public GpPlayServiceImpl(GpPlayMapper playMapper) {
        this.playMapper = playMapper;
    }

    @Override
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    public int insertSelective(GpPlay gpPlay) {
        return playMapper.insertSelective(gpPlay);
    }

    @Override
    @Options(useCache = false, useGeneratedKeys = false)
    @UpdateProvider(type = BaseUpdateProvider.class, method = "dynamicSQL")
    public int updateByPrimaryKeySelective(GpPlay gpPlay) {
        return playMapper.updateByPrimaryKeySelective(gpPlay);
    }

    @Override
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    public List<GpPlay> select(GpPlay gpPlay) {
        return playMapper.select(gpPlay);
    }

    @Override
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    public GpPlay selectByPrimaryKey(Object id) {
        return playMapper.selectByPrimaryKey(id);
    }

    @Override
    @DeleteProvider(type = BaseDeleteProvider.class, method = "dynamicSQL")
    public int deleteByPrimaryKey(Object id) {
        return playMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<GpPlay> queryListPaged(GpPlay gpPlay, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        Example example = new Example(GpPlay.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(gpPlay);
        example.orderBy("lastTime").desc();
        List<GpPlay> gpPlays=playMapper.selectByExample(example);
        return gpPlays;
    }
}
