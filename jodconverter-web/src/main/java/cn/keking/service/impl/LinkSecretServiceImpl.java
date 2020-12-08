package cn.keking.service.impl;


import cn.keking.mapper.LinkSecretRepositoryMapper;
import cn.keking.model.LinkSecret;
import cn.keking.service.LinkSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LinkSecretServiceImpl implements LinkSecretService {
    @Autowired
    private LinkSecretRepositoryMapper linkSecretRepositoryMapper;

    @Override
    public LinkSecret findLinkSecretByLink(String link) {
        return linkSecretRepositoryMapper.findLinkSecretByLocalLink(link);
    }

    @Override
    public LinkSecret findLinkSecretBysecretLink(String secretLink) {
        return linkSecretRepositoryMapper.findLinkSecretBySecretLink(secretLink);
    }

    @Override
    public List<LinkSecret> findLinkSecretsByFileName(String fileName) {
        return linkSecretRepositoryMapper.findLinkSecretsByFileName(fileName);
    }

    @Override
    public LinkSecret findLinkSecretByLocalLinkAndUserName(String localLink, String userName) {
        return linkSecretRepositoryMapper.findLinkSecretByLocalLinkAndUserName(localLink, userName);
    }

    @Override
    public LinkSecret save(LinkSecret linkSecret) {
        return linkSecretRepositoryMapper.save(linkSecret);
    }

    @Override
    public LinkSecret deleteLinkSecretByLink(String link) {
        LinkSecret linkSecret = linkSecretRepositoryMapper.findLinkSecretByLocalLink(link);
        linkSecretRepositoryMapper.delete(linkSecret);
        return linkSecret;
    }

    @Override
    public int addOneToDownloadNum(LinkSecret linkSecret) {
        int downloadNum = linkSecret.getDownloadNum() + 1;
        linkSecretRepositoryMapper.setDownloadNum(downloadNum, linkSecret.getLocalLink());
        return downloadNum;
    }

    @Override
    public Date updateExpireDay(LinkSecret linkSecret, Date date) {
        linkSecretRepositoryMapper.setExpireDay(date, linkSecret.getLocalLink());
        return date;
    }

    @Override
    public List<LinkSecret> findLinkSecretsByUserName(String userName) {
        List<LinkSecret> linkSecretList = linkSecretRepositoryMapper.findLinkSecretsByUserName(userName);
        return linkSecretList;
    }

    @Override
    public Date updateShareDate(LinkSecret linkSecret, Date date) {
        linkSecretRepositoryMapper.setShareDate(date, linkSecret.getLocalLink());
        return date;
    }

}
