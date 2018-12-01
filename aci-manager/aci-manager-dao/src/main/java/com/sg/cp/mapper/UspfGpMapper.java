package com.sg.cp.mapper;

import com.sg.cp.pojo.UspfGp;
import com.sg.cp.pojo.UspfGpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UspfGpMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uspf_gp
     *
     * @mbggenerated Fri Nov 30 21:51:12 CST 2018
     */
    int countByExample(UspfGpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uspf_gp
     *
     * @mbggenerated Fri Nov 30 21:51:12 CST 2018
     */
    int deleteByExample(UspfGpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uspf_gp
     *
     * @mbggenerated Fri Nov 30 21:51:12 CST 2018
     */
    int insert(UspfGp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uspf_gp
     *
     * @mbggenerated Fri Nov 30 21:51:12 CST 2018
     */
    int insertSelective(UspfGp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uspf_gp
     *
     * @mbggenerated Fri Nov 30 21:51:12 CST 2018
     */
    List<UspfGp> selectByExample(UspfGpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uspf_gp
     *
     * @mbggenerated Fri Nov 30 21:51:12 CST 2018
     */
    int updateByExampleSelective(@Param("record") UspfGp record, @Param("example") UspfGpExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table uspf_gp
     *
     * @mbggenerated Fri Nov 30 21:51:12 CST 2018
     */
    int updateByExample(@Param("record") UspfGp record, @Param("example") UspfGpExample example);
}