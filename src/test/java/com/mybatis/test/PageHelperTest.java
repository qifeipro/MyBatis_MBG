package com.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class PageHelperTest {

    /**
     * limit index,PageSize
     * index:当前页的起始索引
     * PageSize：每页显示的条数
     * PageNum：当前页的页码
     * index=(PageNum-1)*PageSize
     *
     * 使用MyBatis的分页插件实现分页功能:
     * 1、需要在查询功能之前开启分页
     * PageHelper.startPage(int PageNum,int PageSize);
     * 2、在查询功能之后获取分页相关信息
     * PageInfo<Emp> page = new PageInfo<>(list,5);
     * list表示分页数据
     * 5表示当前导航分页的数量
     *
     *  pageNum：当前页的页码
     * - pageSize：每页显示的条数
     * - size：当前页显示的真实条数
     * - total：总记录数
     * - pages：总页数
     * - prePage：上一页的页码
     * - nextPage：下一页的页码
     * - isFirstPage/isLastPage：是否为第一页/最后一页
     * - hasPreviousPage/hasNextPage：是否存在上一页/下一页
     * - navigatePages：导航分页的页码数
     * - navigatepageNums：导航分页的页码[1,2,3,4,5]
     */

    @Test
    public void testPageHelper(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
       // Page<Object> page = PageHelper.startPage(2, 4);
        PageHelper.startPage(2, 4);
        List<Emp> list = mapper.selectByExample(null);
        PageInfo<Emp> page = new PageInfo<>(list,5);
        list.forEach(emp -> System.out.println(emp));
        /*System.out.println(page);*/
    }
}
