package com.zgy.multipledatasource.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zgy.multipledatasource.pojo.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author renjiaxin
 * @Date 2020/10/20
 * @Description
 */
// @Mapper标志Mapper文件, @Repository标志DAO，有了这个就没有注入错误了
@Mapper
@Repository
@DS("db1")
public interface WorkerMapper extends BaseMapper<Worker> {
}
