package com.chuanmei.bishe.service.Impl;

import com.chuanmei.bishe.model.Invitation;
import com.chuanmei.bishe.service.InvitationService;

import java.util.List;

public class InvitationServiceImpl implements InvitationService {
    @Override
    public void publishinvitation(String number, String account, String time, String title, String subtitle, String text) {

    }

    @Override
    public void deleteinvitation() {

    }

    @Override
    public Invitation lookinvitation(String number) {
        return null;
    }

    @Override
    public List<Invitation> lookmyinvitations(String account) {
        return null;
    }

    @Override
    public List<Invitation> seekinvitations(String name) {
        return null;
    }

    @Override
    public List<Invitation> lookinvitations() {
        return null;
    }
}
