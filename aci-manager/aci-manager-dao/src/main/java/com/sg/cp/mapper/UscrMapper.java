package com.sg.cp.mapper;

import com.sg.cp.pojo.Uscr;
import com.sg.cp.pojo.UscrExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UscrMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uscr
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    int countByExample(UscrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uscr
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    int deleteByExample(UscrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uscr
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    int insert(Uscr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uscr
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    int insertSelective(Uscr record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uscr
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    List<Uscr> selectByExample(UscrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uscr
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    int updateByExampleSelective(@Param("record") Uscr record, @Param("example") UscrExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uscr
     *
     * @mbggenerated Sat Dec 29 16:19:32 CST 2018
     */
    int updateByExample(@Param("record") Uscr record, @Param("example") UscrExample example);
}