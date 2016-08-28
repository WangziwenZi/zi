package com.zi.dal.relation.user.group.dao;

import com.zi.dal.relation.user.group.entity.UserGroupRelation;
import com.zi.dal.relation.user.group.entity.UserGroupRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int countByExample(UserGroupRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int deleteByExample(UserGroupRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int insert(UserGroupRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int insertSelective(UserGroupRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    List<UserGroupRelation> selectByExampleWithBLOBs(UserGroupRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    List<UserGroupRelation> selectByExample(UserGroupRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    UserGroupRelation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserGroupRelation record, @Param("example") UserGroupRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") UserGroupRelation record, @Param("example") UserGroupRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int updateByExample(@Param("record") UserGroupRelation record, @Param("example") UserGroupRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int updateByPrimaryKeySelective(UserGroupRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(UserGroupRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_group_relation
     *
     * @mbggenerated Sun Aug 28 19:26:27 CST 2016
     */
    int updateByPrimaryKey(UserGroupRelation record);
}