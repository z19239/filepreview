package cn.keking.mapper;


import cn.keking.model.LinkSecret;

import java.util.Date;
import java.util.List;

/**
 * Created by zc on 2018/10/18.
 */
public interface LinkSecretRepositoryMapper{
    LinkSecret findLinkSecretByLocalLink(String localLink);

    LinkSecret findLinkSecretBySecretLink(String secretLink);

    LinkSecret findLinkSecretByLocalLinkAndUserName(String localLink, String userName);

    List<LinkSecret> findLinkSecretsByFileName(String fileName);

    LinkSecret save(LinkSecret linkSecret);

    void delete(LinkSecret linkSecret);

    int setDownloadNum(int downloadNum, String localLink);

    //更新过期时间
    int setExpireDay(Date date, String localLink);

    List<LinkSecret> findLinkSecretsByUserName(String userName);

    int setShareDate(Date date, String localLink);

}
