package indi.wwq.mickey.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface SqlMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
