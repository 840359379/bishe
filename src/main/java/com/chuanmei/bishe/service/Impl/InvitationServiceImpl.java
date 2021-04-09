package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.dao.InvitationDao;
import com.chuanmei.bishe.model.Invitation;
import com.chuanmei.bishe.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvitationServiceImpl implements InvitationService {

    @Autowired
    private InvitationDao invitationDao;

    @Override
    public int publishinvitation(Invitation invitation) {
        return invitationDao.publishinvitation(invitation);
    }

    @Override
    public boolean deleteinvitation(int number) {
        return invitationDao.deleteinvitation(number);
    }

    @Override
    public Invitation lookinvitation(int number) {
        return invitationDao.lookinvitation(number);
    }

    @Override
    public List<Invitation> lookmyinvitations(String account) {
        return invitationDao.lookmyinvitations(account);
    }

    @Override
    public List<Invitation> seekinvitations(String name) {
        return invitationDao.seekinvitations(name);
    }

    @Override
    public List<Invitation> lookinvitations() {
        return invitationDao.lookinvitations();
    }

    @Override
    public void updataText(String text, int number) {
        invitationDao.updataText(text,number);
    }
}
