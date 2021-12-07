package com.example.Clubmanagement.services;

import com.example.Clubmanagement.Repositories.MemberRepo;
import com.example.Clubmanagement.entities.compte.Clubsmembers.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
private  MemberRepo memberRepo;

@Autowired
    public MemberService(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    public List<Members> getClubMembers(Long id) {
    return  memberRepo.findByClubid(id);
    }

    public List<Members> getClubRoles(String role) {
    return  this.memberRepo.findByRole(role);
    }

    public String saveMember(Members member) {
    String s="error";
            Members x = this.memberRepo.save(member);
    if (x.getIdmembre()!=null){
        s="success";
    }
    return s;
    }
}