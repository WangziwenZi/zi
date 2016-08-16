package com.zi.dal.relation.group.right.dao;

import com.zi.dal.relation.group.right.entity.GroupRightRelation;
import com.zi.dal.relation.group.right.entity.GroupRightRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupRightRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    int countByExample(GroupRightRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    int deleteByExample(GroupRightRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    int insert(GroupRightRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    int insertSelective(GroupRightRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    List<GroupRightRelation> selectByExample(GroupRightRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    GroupRightRelation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    int updateByExampleSelective(@Param("record") GroupRightRelation record, @Param("example") GroupRightRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    int updateByExample(@Param("record") GroupRightRelation record, @Param("example") GroupRightRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    int updateByPrimaryKeySelective(GroupRightRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_right_relation
     *
     * @mbggenerated Tue Aug 16 17:40:45 ICT 2016
     */
    int updateByPrimaryKey(GroupRightRelation record);
}