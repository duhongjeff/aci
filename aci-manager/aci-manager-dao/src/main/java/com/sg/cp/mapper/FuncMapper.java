package com.sg.cp.mapper;

import com.sg.cp.pojo.Func;
import com.sg.cp.pojo.FuncExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FuncMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int countByExample(FuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int deleteByExample(FuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int insert(Func record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int insertSelective(Func record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    List<Func> selectByExample(FuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int updateByExampleSelective(@Param("record") Func record, @Param("example") FuncExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table func
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int updateByExample(@Param("record") Func record, @Param("example") FuncExample example);
}