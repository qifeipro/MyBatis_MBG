package com.mybatis.test;

import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.pojo.EmpExample;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MBGTest {

    @Test
    public void TestMBG(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        //查询所有数据
        List<Emp> list = mapper.selectByExample(null);
        list.forEach(emp -> System.out.println(emp));

        //根据条件查询
       /* EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThanOrEqualTo(20);
        empExample.or().andDidIsNotNull();
        List<Emp> list = mapper.selectByExample(empExample);
        list.forEach(emp -> System.out.println(emp));*/

        //根据条件修改
        //mapper.updateByPrimaryKeySelective(new Emp(null, "李四", 21, null, "456@qq.com", 3));


    }

}
