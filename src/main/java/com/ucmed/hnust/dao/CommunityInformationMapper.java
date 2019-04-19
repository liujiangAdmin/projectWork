package com.ucmed.hnust.dao;

import com.ucmed.hnust.pojo.CommunityInformation;

import java.util.List;

/**
 * Created by ZY-LJ-1446 on 2018/1/23.
 */
public interface CommunityInformationMapper {
    //获取社区资料链表合集
    List<CommunityInformation> getList();
    //添加新的社区资料链表
    int addCommunityInformation(CommunityInformation communityInformation);

}
