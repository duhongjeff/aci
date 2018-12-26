package com.sg.cp.mapper;

import com.sg.cp.pojo.UsgpFugp;
import com.sg.cp.pojo.UsgpFugpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsgpFugpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usgp_fugp
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int countByExample(UsgpFugpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usgp_fugp
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int deleteByExample(UsgpFugpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usgp_fugp
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int insert(UsgpFugp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usgp_fugp
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int insertSelective(UsgpFugp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usgp_fugp
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    List<UsgpFugp> selectByExample(UsgpFugpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usgp_fugp
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int updateByExampleSelective(@Param("record") UsgpFugp record, @Param("example") UsgpFugpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table usgp_fugp
     *
     * @mbggenerated Sat Dec 22 10:25:43 CST 2018
     */
    int updateByExample(@Param("record") UsgpFugp record, @Param("example") UsgpFugpExample example);
}