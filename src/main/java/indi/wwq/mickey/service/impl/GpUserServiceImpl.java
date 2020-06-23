package indi.wwq.mickey.service.impl;

import indi.wwq.mickey.mapper.GpUserMapper;
import indi.wwq.mickey.mapper.GpUserMapper;
import indi.wwq.mickey.pojo.GpUser;
import indi.wwq.mickey.pojo.GpUser;
import indi.wwq.mickey.service.GpUserService;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.provider.base.BaseDeleteProvider;
import tk.mybatis.mapper.provider.base.BaseInsertProvider;
import tk.mybatis.mapper.provider.base.BaseSelectProvider;
import tk.mybatis.mapper.provider.base.BaseUpdateProvider;

import java.util.List;
/**
 * <p>GpUserService的实现类,
 * 实现了{@link GpUserServiceImpl#insertSelective(GpUser)},
 * {@link GpUserServiceImpl#selectByPrimaryKey(Object)}
 *{@link GpUserServiceImpl#select(GpUser)}
 * {@link GpUserServiceImpl#updateByPrimaryKeySelective(GpUser)}
 * {@link GpUserServiceImpl#deleteByPrimaryKey(Object)}
 * @author wg
 */
@Service
public class GpUserServiceImpl implements GpUserService {
    private final GpUserMapper userMapper;

    public GpUserServiceImpl(GpUserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    @InsertProvider(type = BaseInsertProvider.class, method = "dynamicSQL")
    public int insertSelective(GpUser gpUser) {
        return userMapper.insertSelective(gpUser);
    }

    @Override
    @Options(useCache = false, useGeneratedKeys = false)
    @UpdateProvider(type = BaseUpdateProvider.class, method = "dynamicSQL")
    public int updateByPrimaryKeySelective(GpUser gpUser) {
        return userMapper.updateByPrimaryKeySelective(gpUser);
    }

    @Override
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    public List<GpUser> select(GpUser gpUser) {
        return userMapper.select(gpUser);
    }

    @Override
    @SelectProvider(type = BaseSelectProvider.class, method = "dynamicSQL")
    public GpUser selectByPrimaryKey(Object id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @DeleteProvider(type = BaseDeleteProvider.class, method = "dynamicSQL")
    public int deleteByPrimaryKey(Object id) {
        return userMapper.deleteByPrimaryKey(id);
    }

}
